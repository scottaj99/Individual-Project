grammar Java;
options {output=template;}

scope slist {
    List locals; // must be defined one per semicolon
    List stats;
}

/*
@slist::init {
    locals = new ArrayList();
    stats = new ArrayList();
}
*/

@header {
import org.antlr.stringtemplate.*;
}
program
scope {
  List globals;
  List functions;
}
@init {
    $program::globals = new ArrayList();
    $program::functions = new ArrayList();
}
    :   declaration+
        -> program(globals={$program::globals},functions={$program::functions})
    ;

declaration
    :   variable   {$program::globals.add($variable.st);}
    |   f=function {$program::functions.add($f.st);}
    ;

// ack is $function.st ambig?  It can mean the rule's dyn scope or
// the ref in this rule.  Ack.


variable
    :   type declarator ';'
        -> {$function.size()>0 && $function::name==null}?
           globalVariable(type={$type.st},name={$declarator.st})
        -> variable(type={$type.st},name={$declarator.st})
    ;

declarator
    :   ID -> {new StringTemplate($ID.text)}
    ;

comment
    :   '//' ID ';'

    // |   '//' ~('\n'|'\r')*     // a line comment could appear at the end of the file without CR/LF
    -> comment(text={$ID.text})
    ; 

function
scope {
    String name;
}
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    :   modifier type ID {$function::name=$ID.text;}
        '(' ( p+=formalParameter ( ',' p+=formalParameter )* )? ')'
        block
        -> function(modifier={$modifier.st}, type={$type.st}, name={$function::name},
                    locals={$slist::locals},
                    stats={$slist::stats},
                    args={$p})
    ;






formalParameter
    :   type declarator 
        -> parameter(type={$type.st},name={$declarator.st})
    ;

modifier 
    :
    |   'public'
    |   'protected'
    |   'private'
    |   'static'
    |   'abstract'
    |   'final'
    |   'native'
    |   'synchronized'
    |   'transient'
    |   'volatile'
    |   'strictfp'
    ;

type
    :   'int'  -> type_int()
    |   'char' -> type_char()
    |   ID     -> type_user_object(name={$ID.text})
    ;

block
    :  '{'
       ( variable {$slist::locals.add($variable.st);} )*
       ( stat {$slist::stats.add($stat.st);})*
       '}'
    ;

stat
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    : forStat -> {$forStat.st}
    |  whileStat -> {$whileStat.st}
    |  ifStat -> {$ifStat.st}
    |  elseStat -> {$elseStat.st}
    | elseIfStat -> {$elseIfStat.st}
    | expr ';' -> statement(expr={$expr.st})
    | block -> statementList(locals={$slist::locals}, stats={$slist::stats})
    | assignStat ';' -> {$assignStat.st}
    | ';' -> {new StringTemplate(";")}

    ;

forStat
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    :   'for' '(' e1=assignStat ';' e2=condExpr ';' e3=assignStat ')' block
        -> forLoop(e1={$e1.st},e2={$e2.st},e3={$e3.st},
                   locals={$slist::locals}, stats={$slist::stats})
    ;

whileStat
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    :   'while' '('e1=expr ')' block
        -> whileLoop(e1={$e1.st},
                   locals={$slist::locals}, stats={$slist::stats})
    ;
ifStat
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    :   'if' '('e1=expr ')' block
        -> if(e1={$e1.st},
                   locals={$slist::locals}, stats={$slist::stats})
    ;

elseStat
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    :   'else' block
        -> else(
                   locals={$slist::locals}, stats={$slist::stats})
    ;

elseIfStat
scope slist;
@init {
  $slist::locals = new ArrayList();
  $slist::stats = new ArrayList();
}
    :   'else' 'if' '('e1=expr ')' block
        -> elif( e1={$e1.st},
                   locals={$slist::locals}, stats={$slist::stats})
    ;

assignStat
    :   ID '=' expr -> assign(lhs={$ID.text}, rhs={$expr.st})
    |   ID '++' ->  increment(id={$ID.text})
    |   ID '--' ->  decrement(id={$ID.text})
    ;

expr:   condExpr -> {$condExpr.st}
    ;

condExpr
    :   a=aexpr
        (   (  '==' b=aexpr -> equals(left={$a.st},right={$b.st})
            |  '!=' b = aexpr -> notEqual(left={$a.st},right={$b.st})
            |  '<' b=aexpr   -> lessThan(left={$a.st},right={$b.st})
            | '.equals('b=aexpr ')' -> equals(left={$a.st},right={$b.st})
            | '>' b=aexpr -> greaterThan(left={$a.st}, right={$b.st})
            | '<=' b=aexpr -> lessEquals(left={$a.st}, right={$b.st})
            | '>=' b=aexpr -> greaterEquals(left={$a.st}, right={$b.st})
            | '||' b=aexpr -> or(left={$a.st}, right={$b.st})
            | '&&' b=aexpr -> and(left={$a.st}, right={$b.st})
            )
        |   -> {$a.st} // else just aexpr
        )
    ;

aexpr
    :   (a=atom -> {$a.st})
        ( '+' b=atom -> add(left={$aexpr.st}, right={$b.st}) )*
        ( '-' b=atom -> subtract(left={$aexpr.st}, right={$b.st}) )*
        ( '*' b=atom -> multiply(left={$aexpr.st}, right={$b.st}) )*
        ( '/' b=atom -> divide(left={$aexpr.st}, right={$b.st}) )*
        ( '%' b=atom -> modulo(left={$aexpr.st}, right={$b.st}) )*

    ;

atom
    : ID -> refVar(id={$ID.text})
    | INT -> iconst(value={$INT.text})
    | '(' expr ')' -> {$expr.st}
    

    ; 

ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT	:	('0'..'9')+
	;


WS  :   (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;}
    ;  

// COMMENT
//     :   '/*' .*? '*/' -> comment(text={$COMMENT.st})
//     ;

// LINE_COMMENT
//     :   '//' ~('\n'|'\r')*  ('\r\n' | '\r' | '\n') 
//     ;

