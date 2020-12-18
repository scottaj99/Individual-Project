// $ANTLR 3.5.2 Java.g 2020-12-18 13:10:00

import org.antlr.stringtemplate.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings("all")
public class JavaParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'!='", "'%'", 
		"'&&'", "'('", "')'", "'*'", "'+'", "'++'", "','", "'-'", "'--'", "'.equals('", 
		"'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'abstract'", 
		"'char'", "'final'", "'for'", "'if'", "'int'", "'native'", "'private'", 
		"'protected'", "'public'", "'static'", "'strictfp'", "'synchronized'", 
		"'transient'", "'volatile'", "'while'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int ID=4;
	public static final int INT=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	protected static class slist_scope {
		List locals;
		List stats;
	}
	protected Stack<slist_scope> slist_stack = new Stack<slist_scope>();


	public JavaParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public JavaParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected StringTemplateGroup templateLib =
	  new StringTemplateGroup("JavaParserTemplates", AngleBracketTemplateLexer.class);

	public void setTemplateLib(StringTemplateGroup templateLib) {
	  this.templateLib = templateLib;
	}
	public StringTemplateGroup getTemplateLib() {
	  return templateLib;
	}
	/** allows convenient multi-value initialization:
	 *  "new STAttrMap().put(...).put(...)"
	 */
	@SuppressWarnings("serial")
	public static class STAttrMap extends HashMap<String, Object> {
		public STAttrMap put(String attrName, Object value) {
			super.put(attrName, value);
			return this;
		}
	}
	@Override public String[] getTokenNames() { return JavaParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Java.g"; }


	protected static class program_scope {
		List globals;
		List functions;
	}
	protected Stack<program_scope> program_stack = new Stack<program_scope>();

	public static class program_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "program"
	// Java.g:19:1: program : ( declaration )+ -> program(globals=$program::globalsfunctions=$program::functions);
	public final JavaParser.program_return program() throws RecognitionException {
		program_stack.push(new program_scope());
		JavaParser.program_return retval = new JavaParser.program_return();
		retval.start = input.LT(1);


		    program_stack.peek().globals = new ArrayList();
		    program_stack.peek().functions = new ArrayList();

		try {
			// Java.g:28:5: ( ( declaration )+ -> program(globals=$program::globalsfunctions=$program::functions))
			// Java.g:28:9: ( declaration )+
			{
			// Java.g:28:9: ( declaration )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID||(LA1_0 >= 27 && LA1_0 <= 29)||(LA1_0 >= 32 && LA1_0 <= 41)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Java.g:28:9: declaration
					{
					pushFollow(FOLLOW_declaration_in_program47);
					declaration();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// TEMPLATE REWRITE
			// 29:9: -> program(globals=$program::globalsfunctions=$program::functions)
			{
				retval.st = templateLib.getInstanceOf("program",new STAttrMap().put("globals", program_stack.peek().globals).put("functions", program_stack.peek().functions));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			program_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class declaration_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "declaration"
	// Java.g:32:1: declaration : ( variable |f= function );
	public final JavaParser.declaration_return declaration() throws RecognitionException {
		JavaParser.declaration_return retval = new JavaParser.declaration_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope f =null;
		ParserRuleReturnScope variable1 =null;

		try {
			// Java.g:33:5: ( variable |f= function )
			int alt2=2;
			switch ( input.LA(1) ) {
			case 32:
				{
				int LA2_1 = input.LA(2);
				if ( (LA2_1==ID) ) {
					int LA2_5 = input.LA(3);
					if ( (LA2_5==20) ) {
						alt2=1;
					}
					else if ( (LA2_5==10) ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 28:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==ID) ) {
					int LA2_5 = input.LA(3);
					if ( (LA2_5==20) ) {
						alt2=1;
					}
					else if ( (LA2_5==10) ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ID:
				{
				int LA2_3 = input.LA(2);
				if ( (LA2_3==ID) ) {
					int LA2_5 = input.LA(3);
					if ( (LA2_5==20) ) {
						alt2=1;
					}
					else if ( (LA2_5==10) ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 27:
			case 29:
			case 33:
			case 34:
			case 35:
			case 36:
			case 37:
			case 38:
			case 39:
			case 40:
			case 41:
				{
				alt2=2;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// Java.g:33:9: variable
					{
					pushFollow(FOLLOW_variable_in_declaration88);
					variable1=variable();
					state._fsp--;

					program_stack.peek().globals.add((variable1!=null?((StringTemplate)variable1.getTemplate()):null));
					}
					break;
				case 2 :
					// Java.g:34:9: f= function
					{
					pushFollow(FOLLOW_function_in_declaration104);
					f=function();
					state._fsp--;

					program_stack.peek().functions.add((f!=null?((StringTemplate)f.getTemplate()):null));
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class variable_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "variable"
	// Java.g:41:1: variable : type declarator ';' -> {$function.size()>0 && $function::name==null}? globalVariable(type=$type.stname=$declarator.st) -> variable(type=$type.stname=$declarator.st);
	public final JavaParser.variable_return variable() throws RecognitionException {
		JavaParser.variable_return retval = new JavaParser.variable_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope type2 =null;
		ParserRuleReturnScope declarator3 =null;

		try {
			// Java.g:42:5: ( type declarator ';' -> {$function.size()>0 && $function::name==null}? globalVariable(type=$type.stname=$declarator.st) -> variable(type=$type.stname=$declarator.st))
			// Java.g:42:9: type declarator ';'
			{
			pushFollow(FOLLOW_type_in_variable129);
			type2=type();
			state._fsp--;

			pushFollow(FOLLOW_declarator_in_variable131);
			declarator3=declarator();
			state._fsp--;

			match(input,20,FOLLOW_20_in_variable133); 
			// TEMPLATE REWRITE
			// 43:9: -> {$function.size()>0 && $function::name==null}? globalVariable(type=$type.stname=$declarator.st)
			if (function_stack.size()>0 && function_stack.peek().name==null) {
				retval.st = templateLib.getInstanceOf("globalVariable",new STAttrMap().put("type", (type2!=null?((StringTemplate)type2.getTemplate()):null)).put("name", (declarator3!=null?((StringTemplate)declarator3.getTemplate()):null)));
			}

			else // 45:9: -> variable(type=$type.stname=$declarator.st)
			{
				retval.st = templateLib.getInstanceOf("variable",new STAttrMap().put("type", (type2!=null?((StringTemplate)type2.getTemplate()):null)).put("name", (declarator3!=null?((StringTemplate)declarator3.getTemplate()):null)));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "variable"


	public static class declarator_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "declarator"
	// Java.g:48:1: declarator : ID -> {new StringTemplate($ID.text)};
	public final JavaParser.declarator_return declarator() throws RecognitionException {
		JavaParser.declarator_return retval = new JavaParser.declarator_return();
		retval.start = input.LT(1);

		Token ID4=null;

		try {
			// Java.g:49:5: ( ID -> {new StringTemplate($ID.text)})
			// Java.g:49:9: ID
			{
			ID4=(Token)match(input,ID,FOLLOW_ID_in_declarator207); 
			// TEMPLATE REWRITE
			// 49:12: -> {new StringTemplate($ID.text)}
			{
				retval.st = new StringTemplate((ID4!=null?ID4.getText():null));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declarator"


	protected static class function_scope {
		String name;
	}
	protected Stack<function_scope> function_stack = new Stack<function_scope>();

	public static class function_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "function"
	// Java.g:52:1: function : modifier type ID '(' (p+= formalParameter ( ',' p+= formalParameter )* )? ')' block -> function(modifier=$modifier.sttype=$type.stname=$function::namelocals=$slist::localsstats=$slist::statsargs=$p);
	public final JavaParser.function_return function() throws RecognitionException {
		slist_stack.push(new slist_scope());
		function_stack.push(new function_scope());
		JavaParser.function_return retval = new JavaParser.function_return();
		retval.start = input.LT(1);

		Token ID5=null;
		List<Object> list_p=null;
		ParserRuleReturnScope modifier6 =null;
		ParserRuleReturnScope type7 =null;
		RuleReturnScope p = null;

		  slist_stack.peek().locals = new ArrayList();
		  slist_stack.peek().stats = new ArrayList();

		try {
			// Java.g:61:5: ( modifier type ID '(' (p+= formalParameter ( ',' p+= formalParameter )* )? ')' block -> function(modifier=$modifier.sttype=$type.stname=$function::namelocals=$slist::localsstats=$slist::statsargs=$p))
			// Java.g:61:9: modifier type ID '(' (p+= formalParameter ( ',' p+= formalParameter )* )? ')' block
			{
			pushFollow(FOLLOW_modifier_in_function244);
			modifier6=modifier();
			state._fsp--;

			pushFollow(FOLLOW_type_in_function246);
			type7=type();
			state._fsp--;

			ID5=(Token)match(input,ID,FOLLOW_ID_in_function248); 
			function_stack.peek().name =(ID5!=null?ID5.getText():null);
			match(input,10,FOLLOW_10_in_function260); 
			// Java.g:62:13: (p+= formalParameter ( ',' p+= formalParameter )* )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID||LA4_0==28||LA4_0==32) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// Java.g:62:15: p+= formalParameter ( ',' p+= formalParameter )*
					{
					pushFollow(FOLLOW_formalParameter_in_function266);
					p=formalParameter();
					state._fsp--;

					if (list_p==null) list_p=new ArrayList<Object>();
					list_p.add(p.getTemplate());
					// Java.g:62:34: ( ',' p+= formalParameter )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==15) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// Java.g:62:36: ',' p+= formalParameter
							{
							match(input,15,FOLLOW_15_in_function270); 
							pushFollow(FOLLOW_formalParameter_in_function274);
							p=formalParameter();
							state._fsp--;

							if (list_p==null) list_p=new ArrayList<Object>();
							list_p.add(p.getTemplate());
							}
							break;

						default :
							break loop3;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_function282); 
			pushFollow(FOLLOW_block_in_function292);
			block();
			state._fsp--;

			// TEMPLATE REWRITE
			// 64:9: -> function(modifier=$modifier.sttype=$type.stname=$function::namelocals=$slist::localsstats=$slist::statsargs=$p)
			{
				retval.st = templateLib.getInstanceOf("function",new STAttrMap().put("modifier", (modifier6!=null?((StringTemplate)modifier6.getTemplate()):null)).put("type", (type7!=null?((StringTemplate)type7.getTemplate()):null)).put("name", function_stack.peek().name).put("locals", slist_stack.peek().locals).put("stats", slist_stack.peek().stats).put("args", list_p));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			slist_stack.pop();
			function_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class formalParameter_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "formalParameter"
	// Java.g:75:1: formalParameter : type declarator -> parameter(type=$type.stname=$declarator.st);
	public final JavaParser.formalParameter_return formalParameter() throws RecognitionException {
		JavaParser.formalParameter_return retval = new JavaParser.formalParameter_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope type8 =null;
		ParserRuleReturnScope declarator9 =null;

		try {
			// Java.g:76:5: ( type declarator -> parameter(type=$type.stname=$declarator.st))
			// Java.g:76:9: type declarator
			{
			pushFollow(FOLLOW_type_in_formalParameter418);
			type8=type();
			state._fsp--;

			pushFollow(FOLLOW_declarator_in_formalParameter420);
			declarator9=declarator();
			state._fsp--;

			// TEMPLATE REWRITE
			// 77:9: -> parameter(type=$type.stname=$declarator.st)
			{
				retval.st = templateLib.getInstanceOf("parameter",new STAttrMap().put("type", (type8!=null?((StringTemplate)type8.getTemplate()):null)).put("name", (declarator9!=null?((StringTemplate)declarator9.getTemplate()):null)));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "formalParameter"


	public static class modifier_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "modifier"
	// Java.g:80:1: modifier : (| 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' );
	public final JavaParser.modifier_return modifier() throws RecognitionException {
		JavaParser.modifier_return retval = new JavaParser.modifier_return();
		retval.start = input.LT(1);

		try {
			// Java.g:81:5: (| 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )
			int alt5=12;
			switch ( input.LA(1) ) {
			case ID:
			case 28:
			case 32:
				{
				alt5=1;
				}
				break;
			case 36:
				{
				alt5=2;
				}
				break;
			case 35:
				{
				alt5=3;
				}
				break;
			case 34:
				{
				alt5=4;
				}
				break;
			case 37:
				{
				alt5=5;
				}
				break;
			case 27:
				{
				alt5=6;
				}
				break;
			case 29:
				{
				alt5=7;
				}
				break;
			case 33:
				{
				alt5=8;
				}
				break;
			case 39:
				{
				alt5=9;
				}
				break;
			case 40:
				{
				alt5=10;
				}
				break;
			case 41:
				{
				alt5=11;
				}
				break;
			case 38:
				{
				alt5=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// Java.g:82:5: 
					{
					}
					break;
				case 2 :
					// Java.g:82:9: 'public'
					{
					match(input,36,FOLLOW_36_in_modifier468); 
					}
					break;
				case 3 :
					// Java.g:83:9: 'protected'
					{
					match(input,35,FOLLOW_35_in_modifier478); 
					}
					break;
				case 4 :
					// Java.g:84:9: 'private'
					{
					match(input,34,FOLLOW_34_in_modifier488); 
					}
					break;
				case 5 :
					// Java.g:85:9: 'static'
					{
					match(input,37,FOLLOW_37_in_modifier498); 
					}
					break;
				case 6 :
					// Java.g:86:9: 'abstract'
					{
					match(input,27,FOLLOW_27_in_modifier508); 
					}
					break;
				case 7 :
					// Java.g:87:9: 'final'
					{
					match(input,29,FOLLOW_29_in_modifier518); 
					}
					break;
				case 8 :
					// Java.g:88:9: 'native'
					{
					match(input,33,FOLLOW_33_in_modifier528); 
					}
					break;
				case 9 :
					// Java.g:89:9: 'synchronized'
					{
					match(input,39,FOLLOW_39_in_modifier538); 
					}
					break;
				case 10 :
					// Java.g:90:9: 'transient'
					{
					match(input,40,FOLLOW_40_in_modifier548); 
					}
					break;
				case 11 :
					// Java.g:91:9: 'volatile'
					{
					match(input,41,FOLLOW_41_in_modifier558); 
					}
					break;
				case 12 :
					// Java.g:92:9: 'strictfp'
					{
					match(input,38,FOLLOW_38_in_modifier568); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "modifier"


	public static class type_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "type"
	// Java.g:95:1: type : ( 'int' -> type_int(| 'char' -> type_char(| ID -> type_user_object(name=$ID.text));
	public final JavaParser.type_return type() throws RecognitionException {
		JavaParser.type_return retval = new JavaParser.type_return();
		retval.start = input.LT(1);

		Token ID10=null;

		try {
			// Java.g:96:5: ( 'int' -> type_int(| 'char' -> type_char(| ID -> type_user_object(name=$ID.text))
			int alt6=3;
			switch ( input.LA(1) ) {
			case 32:
				{
				alt6=1;
				}
				break;
			case 28:
				{
				alt6=2;
				}
				break;
			case ID:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// Java.g:96:9: 'int'
					{
					match(input,32,FOLLOW_32_in_type587); 
					// TEMPLATE REWRITE
					// 96:16: -> type_int(
					{
						retval.st = templateLib.getInstanceOf("type_int");
					}



					}
					break;
				case 2 :
					// Java.g:97:9: 'char'
					{
					match(input,28,FOLLOW_28_in_type604); 
					// TEMPLATE REWRITE
					// 97:16: -> type_char(
					{
						retval.st = templateLib.getInstanceOf("type_char");
					}



					}
					break;
				case 3 :
					// Java.g:98:9: ID
					{
					ID10=(Token)match(input,ID,FOLLOW_ID_in_type620); 
					// TEMPLATE REWRITE
					// 98:16: -> type_user_object(name=$ID.text)
					{
						retval.st = templateLib.getInstanceOf("type_user_object",new STAttrMap().put("name", (ID10!=null?ID10.getText():null)));
					}



					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class block_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "block"
	// Java.g:101:1: block : '{' ( variable )* ( stat )* '}' ;
	public final JavaParser.block_return block() throws RecognitionException {
		JavaParser.block_return retval = new JavaParser.block_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope variable11 =null;
		ParserRuleReturnScope stat12 =null;

		try {
			// Java.g:102:5: ( '{' ( variable )* ( stat )* '}' )
			// Java.g:102:8: '{' ( variable )* ( stat )* '}'
			{
			match(input,43,FOLLOW_43_in_block651); 
			// Java.g:103:8: ( variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ID) ) {
					int LA7_2 = input.LA(2);
					if ( (LA7_2==ID) ) {
						alt7=1;
					}

				}
				else if ( (LA7_0==28||LA7_0==32) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Java.g:103:10: variable
					{
					pushFollow(FOLLOW_variable_in_block662);
					variable11=variable();
					state._fsp--;

					slist_stack.peek().locals.add((variable11!=null?((StringTemplate)variable11.getTemplate()):null));
					}
					break;

				default :
					break loop7;
				}
			}

			// Java.g:104:8: ( stat )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= ID && LA8_0 <= INT)||LA8_0==10||LA8_0==20||(LA8_0 >= 30 && LA8_0 <= 31)||(LA8_0 >= 42 && LA8_0 <= 43)) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// Java.g:104:10: stat
					{
					pushFollow(FOLLOW_stat_in_block678);
					stat12=stat();
					state._fsp--;

					slist_stack.peek().stats.add((stat12!=null?((StringTemplate)stat12.getTemplate()):null));
					}
					break;

				default :
					break loop8;
				}
			}

			match(input,45,FOLLOW_45_in_block691); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class stat_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "stat"
	// Java.g:108:1: stat : ( forStat -> {$forStat.st}| whileStat -> {$whileStat.st}| ifStat -> {$ifStat.st}| expr ';' -> statement(expr=$expr.st)| block -> statementList(locals=$slist::localsstats=$slist::stats)| assignStat ';' -> {$assignStat.st}| ';' -> {new StringTemplate(\";\")});
	public final JavaParser.stat_return stat() throws RecognitionException {
		slist_stack.push(new slist_scope());

		JavaParser.stat_return retval = new JavaParser.stat_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope forStat13 =null;
		ParserRuleReturnScope whileStat14 =null;
		ParserRuleReturnScope ifStat15 =null;
		ParserRuleReturnScope expr16 =null;
		ParserRuleReturnScope assignStat17 =null;


		  slist_stack.peek().locals = new ArrayList();
		  slist_stack.peek().stats = new ArrayList();

		try {
			// Java.g:114:5: ( forStat -> {$forStat.st}| whileStat -> {$whileStat.st}| ifStat -> {$ifStat.st}| expr ';' -> statement(expr=$expr.st)| block -> statementList(locals=$slist::localsstats=$slist::stats)| assignStat ';' -> {$assignStat.st}| ';' -> {new StringTemplate(\";\")})
			int alt9=7;
			switch ( input.LA(1) ) {
			case 30:
				{
				alt9=1;
				}
				break;
			case 42:
				{
				alt9=2;
				}
				break;
			case 31:
				{
				alt9=3;
				}
				break;
			case ID:
				{
				int LA9_4 = input.LA(2);
				if ( (LA9_4==14||LA9_4==17||LA9_4==23) ) {
					alt9=6;
				}
				else if ( ((LA9_4 >= 7 && LA9_4 <= 9)||(LA9_4 >= 12 && LA9_4 <= 13)||LA9_4==16||(LA9_4 >= 18 && LA9_4 <= 22)||(LA9_4 >= 24 && LA9_4 <= 26)||LA9_4==44) ) {
					alt9=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case INT:
			case 10:
				{
				alt9=4;
				}
				break;
			case 43:
				{
				alt9=5;
				}
				break;
			case 20:
				{
				alt9=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// Java.g:114:7: forStat
					{
					pushFollow(FOLLOW_forStat_in_stat718);
					forStat13=forStat();
					state._fsp--;

					// TEMPLATE REWRITE
					// 114:15: -> {$forStat.st}
					{
						retval.st = (forStat13!=null?((StringTemplate)forStat13.getTemplate()):null);
					}



					}
					break;
				case 2 :
					// Java.g:115:8: whileStat
					{
					pushFollow(FOLLOW_whileStat_in_stat731);
					whileStat14=whileStat();
					state._fsp--;

					// TEMPLATE REWRITE
					// 115:18: -> {$whileStat.st}
					{
						retval.st = (whileStat14!=null?((StringTemplate)whileStat14.getTemplate()):null);
					}



					}
					break;
				case 3 :
					// Java.g:116:8: ifStat
					{
					pushFollow(FOLLOW_ifStat_in_stat744);
					ifStat15=ifStat();
					state._fsp--;

					// TEMPLATE REWRITE
					// 116:15: -> {$ifStat.st}
					{
						retval.st = (ifStat15!=null?((StringTemplate)ifStat15.getTemplate()):null);
					}



					}
					break;
				case 4 :
					// Java.g:117:7: expr ';'
					{
					pushFollow(FOLLOW_expr_in_stat756);
					expr16=expr();
					state._fsp--;

					match(input,20,FOLLOW_20_in_stat758); 
					// TEMPLATE REWRITE
					// 117:16: -> statement(expr=$expr.st)
					{
						retval.st = templateLib.getInstanceOf("statement",new STAttrMap().put("expr", (expr16!=null?((StringTemplate)expr16.getTemplate()):null)));
					}



					}
					break;
				case 5 :
					// Java.g:118:7: block
					{
					pushFollow(FOLLOW_block_in_stat775);
					block();
					state._fsp--;

					// TEMPLATE REWRITE
					// 118:13: -> statementList(locals=$slist::localsstats=$slist::stats)
					{
						retval.st = templateLib.getInstanceOf("statementList",new STAttrMap().put("locals", slist_stack.peek().locals).put("stats", slist_stack.peek().stats));
					}



					}
					break;
				case 6 :
					// Java.g:119:7: assignStat ';'
					{
					pushFollow(FOLLOW_assignStat_in_stat797);
					assignStat17=assignStat();
					state._fsp--;

					match(input,20,FOLLOW_20_in_stat799); 
					// TEMPLATE REWRITE
					// 119:22: -> {$assignStat.st}
					{
						retval.st = (assignStat17!=null?((StringTemplate)assignStat17.getTemplate()):null);
					}



					}
					break;
				case 7 :
					// Java.g:120:7: ';'
					{
					match(input,20,FOLLOW_20_in_stat811); 
					// TEMPLATE REWRITE
					// 120:11: -> {new StringTemplate(\";\")}
					{
						retval.st = new StringTemplate(";");
					}



					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			slist_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "stat"


	public static class forStat_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "forStat"
	// Java.g:124:1: forStat : 'for' '(' e1= assignStat ';' e2= condExpr ';' e3= assignStat ')' block -> forLoop(e1=$e1.ste2=$e2.ste3=$e3.stlocals=$slist::localsstats=$slist::stats);
	public final JavaParser.forStat_return forStat() throws RecognitionException {
		slist_stack.push(new slist_scope());

		JavaParser.forStat_return retval = new JavaParser.forStat_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope e3 =null;


		  slist_stack.peek().locals = new ArrayList();
		  slist_stack.peek().stats = new ArrayList();

		try {
			// Java.g:130:5: ( 'for' '(' e1= assignStat ';' e2= condExpr ';' e3= assignStat ')' block -> forLoop(e1=$e1.ste2=$e2.ste3=$e3.stlocals=$slist::localsstats=$slist::stats))
			// Java.g:130:9: 'for' '(' e1= assignStat ';' e2= condExpr ';' e3= assignStat ')' block
			{
			match(input,30,FOLLOW_30_in_forStat845); 
			match(input,10,FOLLOW_10_in_forStat847); 
			pushFollow(FOLLOW_assignStat_in_forStat851);
			e1=assignStat();
			state._fsp--;

			match(input,20,FOLLOW_20_in_forStat853); 
			pushFollow(FOLLOW_condExpr_in_forStat857);
			e2=condExpr();
			state._fsp--;

			match(input,20,FOLLOW_20_in_forStat859); 
			pushFollow(FOLLOW_assignStat_in_forStat863);
			e3=assignStat();
			state._fsp--;

			match(input,11,FOLLOW_11_in_forStat865); 
			pushFollow(FOLLOW_block_in_forStat867);
			block();
			state._fsp--;

			// TEMPLATE REWRITE
			// 131:9: -> forLoop(e1=$e1.ste2=$e2.ste3=$e3.stlocals=$slist::localsstats=$slist::stats)
			{
				retval.st = templateLib.getInstanceOf("forLoop",new STAttrMap().put("e1", (e1!=null?((StringTemplate)e1.getTemplate()):null)).put("e2", (e2!=null?((StringTemplate)e2.getTemplate()):null)).put("e3", (e3!=null?((StringTemplate)e3.getTemplate()):null)).put("locals", slist_stack.peek().locals).put("stats", slist_stack.peek().stats));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			slist_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "forStat"


	public static class whileStat_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "whileStat"
	// Java.g:135:1: whileStat : 'while' '(' e1= expr ')' block -> whileLoop(e1=$e1.stlocals=$slist::localsstats=$slist::stats);
	public final JavaParser.whileStat_return whileStat() throws RecognitionException {
		slist_stack.push(new slist_scope());

		JavaParser.whileStat_return retval = new JavaParser.whileStat_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope e1 =null;


		  slist_stack.peek().locals = new ArrayList();
		  slist_stack.peek().stats = new ArrayList();

		try {
			// Java.g:141:5: ( 'while' '(' e1= expr ')' block -> whileLoop(e1=$e1.stlocals=$slist::localsstats=$slist::stats))
			// Java.g:141:9: 'while' '(' e1= expr ')' block
			{
			match(input,42,FOLLOW_42_in_whileStat950); 
			match(input,10,FOLLOW_10_in_whileStat952); 
			pushFollow(FOLLOW_expr_in_whileStat955);
			e1=expr();
			state._fsp--;

			match(input,11,FOLLOW_11_in_whileStat957); 
			pushFollow(FOLLOW_block_in_whileStat959);
			block();
			state._fsp--;

			// TEMPLATE REWRITE
			// 142:9: -> whileLoop(e1=$e1.stlocals=$slist::localsstats=$slist::stats)
			{
				retval.st = templateLib.getInstanceOf("whileLoop",new STAttrMap().put("e1", (e1!=null?((StringTemplate)e1.getTemplate()):null)).put("locals", slist_stack.peek().locals).put("stats", slist_stack.peek().stats));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			slist_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "whileStat"


	public static class ifStat_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "ifStat"
	// Java.g:145:1: ifStat : 'if' '(' e1= expr ')' block -> if(e1=$e1.stlocals=$slist::localsstats=$slist::stats);
	public final JavaParser.ifStat_return ifStat() throws RecognitionException {
		slist_stack.push(new slist_scope());

		JavaParser.ifStat_return retval = new JavaParser.ifStat_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope e1 =null;


		  slist_stack.peek().locals = new ArrayList();
		  slist_stack.peek().stats = new ArrayList();

		try {
			// Java.g:151:5: ( 'if' '(' e1= expr ')' block -> if(e1=$e1.stlocals=$slist::localsstats=$slist::stats))
			// Java.g:151:9: 'if' '(' e1= expr ')' block
			{
			match(input,31,FOLLOW_31_in_ifStat1033); 
			match(input,10,FOLLOW_10_in_ifStat1035); 
			pushFollow(FOLLOW_expr_in_ifStat1038);
			e1=expr();
			state._fsp--;

			match(input,11,FOLLOW_11_in_ifStat1040); 
			pushFollow(FOLLOW_block_in_ifStat1042);
			block();
			state._fsp--;

			// TEMPLATE REWRITE
			// 152:9: -> if(e1=$e1.stlocals=$slist::localsstats=$slist::stats)
			{
				retval.st = templateLib.getInstanceOf("if",new STAttrMap().put("e1", (e1!=null?((StringTemplate)e1.getTemplate()):null)).put("locals", slist_stack.peek().locals).put("stats", slist_stack.peek().stats));
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
			slist_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "ifStat"


	public static class assignStat_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "assignStat"
	// Java.g:157:1: assignStat : ( ID '=' expr -> assign(lhs=$ID.textrhs=$expr.st)| ID '++' -> increment(id=$ID.text)| ID '--' -> decrement(id=$ID.text));
	public final JavaParser.assignStat_return assignStat() throws RecognitionException {
		JavaParser.assignStat_return retval = new JavaParser.assignStat_return();
		retval.start = input.LT(1);

		Token ID18=null;
		Token ID20=null;
		Token ID21=null;
		ParserRuleReturnScope expr19 =null;

		try {
			// Java.g:158:5: ( ID '=' expr -> assign(lhs=$ID.textrhs=$expr.st)| ID '++' -> increment(id=$ID.text)| ID '--' -> decrement(id=$ID.text))
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ID) ) {
				switch ( input.LA(2) ) {
				case 23:
					{
					alt10=1;
					}
					break;
				case 14:
					{
					alt10=2;
					}
					break;
				case 17:
					{
					alt10=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// Java.g:158:9: ID '=' expr
					{
					ID18=(Token)match(input,ID,FOLLOW_ID_in_assignStat1108); 
					match(input,23,FOLLOW_23_in_assignStat1110); 
					pushFollow(FOLLOW_expr_in_assignStat1112);
					expr19=expr();
					state._fsp--;

					// TEMPLATE REWRITE
					// 158:21: -> assign(lhs=$ID.textrhs=$expr.st)
					{
						retval.st = templateLib.getInstanceOf("assign",new STAttrMap().put("lhs", (ID18!=null?ID18.getText():null)).put("rhs", (expr19!=null?((StringTemplate)expr19.getTemplate()):null)));
					}



					}
					break;
				case 2 :
					// Java.g:159:9: ID '++'
					{
					ID20=(Token)match(input,ID,FOLLOW_ID_in_assignStat1136); 
					match(input,14,FOLLOW_14_in_assignStat1138); 
					// TEMPLATE REWRITE
					// 159:17: -> increment(id=$ID.text)
					{
						retval.st = templateLib.getInstanceOf("increment",new STAttrMap().put("id", (ID20!=null?ID20.getText():null)));
					}



					}
					break;
				case 3 :
					// Java.g:160:9: ID '--'
					{
					ID21=(Token)match(input,ID,FOLLOW_ID_in_assignStat1158); 
					match(input,17,FOLLOW_17_in_assignStat1160); 
					// TEMPLATE REWRITE
					// 160:17: -> decrement(id=$ID.text)
					{
						retval.st = templateLib.getInstanceOf("decrement",new STAttrMap().put("id", (ID21!=null?ID21.getText():null)));
					}



					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignStat"


	public static class expr_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "expr"
	// Java.g:163:1: expr : condExpr -> {$condExpr.st};
	public final JavaParser.expr_return expr() throws RecognitionException {
		JavaParser.expr_return retval = new JavaParser.expr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope condExpr22 =null;

		try {
			// Java.g:163:5: ( condExpr -> {$condExpr.st})
			// Java.g:163:9: condExpr
			{
			pushFollow(FOLLOW_condExpr_in_expr1184);
			condExpr22=condExpr();
			state._fsp--;

			// TEMPLATE REWRITE
			// 163:18: -> {$condExpr.st}
			{
				retval.st = (condExpr22!=null?((StringTemplate)condExpr22.getTemplate()):null);
			}



			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class condExpr_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "condExpr"
	// Java.g:166:1: condExpr : a= aexpr ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '!=' b= aexpr -> notEqual(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)| '.equals(' b= aexpr ')' -> equals(left=$a.stright=$b.st)| '>' b= aexpr -> greaterThan(left=$a.stright=$b.st)| '<=' b= aexpr -> lessEquals(left=$a.stright=$b.st)| '>=' b= aexpr -> greaterEquals(left=$a.stright=$b.st)| '||' b= aexpr -> or(left=$a.stright=$b.st)| '&&' b= aexpr -> and(left=$a.stright=$b.st)) | -> {$a.st}) ;
	public final JavaParser.condExpr_return condExpr() throws RecognitionException {
		JavaParser.condExpr_return retval = new JavaParser.condExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;

		try {
			// Java.g:167:5: (a= aexpr ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '!=' b= aexpr -> notEqual(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)| '.equals(' b= aexpr ')' -> equals(left=$a.stright=$b.st)| '>' b= aexpr -> greaterThan(left=$a.stright=$b.st)| '<=' b= aexpr -> lessEquals(left=$a.stright=$b.st)| '>=' b= aexpr -> greaterEquals(left=$a.stright=$b.st)| '||' b= aexpr -> or(left=$a.stright=$b.st)| '&&' b= aexpr -> and(left=$a.stright=$b.st)) | -> {$a.st}) )
			// Java.g:167:9: a= aexpr ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '!=' b= aexpr -> notEqual(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)| '.equals(' b= aexpr ')' -> equals(left=$a.stright=$b.st)| '>' b= aexpr -> greaterThan(left=$a.stright=$b.st)| '<=' b= aexpr -> lessEquals(left=$a.stright=$b.st)| '>=' b= aexpr -> greaterEquals(left=$a.stright=$b.st)| '||' b= aexpr -> or(left=$a.stright=$b.st)| '&&' b= aexpr -> and(left=$a.stright=$b.st)) | -> {$a.st})
			{
			pushFollow(FOLLOW_aexpr_in_condExpr1209);
			a=aexpr();
			state._fsp--;

			// Java.g:168:9: ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '!=' b= aexpr -> notEqual(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)| '.equals(' b= aexpr ')' -> equals(left=$a.stright=$b.st)| '>' b= aexpr -> greaterThan(left=$a.stright=$b.st)| '<=' b= aexpr -> lessEquals(left=$a.stright=$b.st)| '>=' b= aexpr -> greaterEquals(left=$a.stright=$b.st)| '||' b= aexpr -> or(left=$a.stright=$b.st)| '&&' b= aexpr -> and(left=$a.stright=$b.st)) | -> {$a.st})
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==7||LA12_0==9||LA12_0==18||(LA12_0 >= 21 && LA12_0 <= 22)||(LA12_0 >= 24 && LA12_0 <= 26)||LA12_0==44) ) {
				alt12=1;
			}
			else if ( (LA12_0==11||LA12_0==20) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// Java.g:168:13: ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '!=' b= aexpr -> notEqual(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)| '.equals(' b= aexpr ')' -> equals(left=$a.stright=$b.st)| '>' b= aexpr -> greaterThan(left=$a.stright=$b.st)| '<=' b= aexpr -> lessEquals(left=$a.stright=$b.st)| '>=' b= aexpr -> greaterEquals(left=$a.stright=$b.st)| '||' b= aexpr -> or(left=$a.stright=$b.st)| '&&' b= aexpr -> and(left=$a.stright=$b.st))
					{
					// Java.g:168:13: ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '!=' b= aexpr -> notEqual(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)| '.equals(' b= aexpr ')' -> equals(left=$a.stright=$b.st)| '>' b= aexpr -> greaterThan(left=$a.stright=$b.st)| '<=' b= aexpr -> lessEquals(left=$a.stright=$b.st)| '>=' b= aexpr -> greaterEquals(left=$a.stright=$b.st)| '||' b= aexpr -> or(left=$a.stright=$b.st)| '&&' b= aexpr -> and(left=$a.stright=$b.st))
					int alt11=9;
					switch ( input.LA(1) ) {
					case 24:
						{
						alt11=1;
						}
						break;
					case 7:
						{
						alt11=2;
						}
						break;
					case 21:
						{
						alt11=3;
						}
						break;
					case 18:
						{
						alt11=4;
						}
						break;
					case 25:
						{
						alt11=5;
						}
						break;
					case 22:
						{
						alt11=6;
						}
						break;
					case 26:
						{
						alt11=7;
						}
						break;
					case 44:
						{
						alt11=8;
						}
						break;
					case 9:
						{
						alt11=9;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}
					switch (alt11) {
						case 1 :
							// Java.g:168:16: '==' b= aexpr
							{
							match(input,24,FOLLOW_24_in_condExpr1226); 
							pushFollow(FOLLOW_aexpr_in_condExpr1230);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 168:29: -> equals(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("equals",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 2 :
							// Java.g:169:16: '!=' b= aexpr
							{
							match(input,7,FOLLOW_7_in_condExpr1260); 
							pushFollow(FOLLOW_aexpr_in_condExpr1266);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 169:31: -> notEqual(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("notEqual",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 3 :
							// Java.g:170:16: '<' b= aexpr
							{
							match(input,21,FOLLOW_21_in_condExpr1296); 
							pushFollow(FOLLOW_aexpr_in_condExpr1300);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 170:30: -> lessThan(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("lessThan",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 4 :
							// Java.g:171:15: '.equals(' b= aexpr ')'
							{
							match(input,18,FOLLOW_18_in_condExpr1331); 
							pushFollow(FOLLOW_aexpr_in_condExpr1334);
							b=aexpr();
							state._fsp--;

							match(input,11,FOLLOW_11_in_condExpr1336); 
							// TEMPLATE REWRITE
							// 171:37: -> equals(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("equals",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 5 :
							// Java.g:172:15: '>' b= aexpr
							{
							match(input,25,FOLLOW_25_in_condExpr1365); 
							pushFollow(FOLLOW_aexpr_in_condExpr1369);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 172:27: -> greaterThan(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("greaterThan",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 6 :
							// Java.g:173:15: '<=' b= aexpr
							{
							match(input,22,FOLLOW_22_in_condExpr1399); 
							pushFollow(FOLLOW_aexpr_in_condExpr1403);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 173:28: -> lessEquals(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("lessEquals",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 7 :
							// Java.g:174:15: '>=' b= aexpr
							{
							match(input,26,FOLLOW_26_in_condExpr1433); 
							pushFollow(FOLLOW_aexpr_in_condExpr1437);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 174:28: -> greaterEquals(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("greaterEquals",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 8 :
							// Java.g:175:15: '||' b= aexpr
							{
							match(input,44,FOLLOW_44_in_condExpr1467); 
							pushFollow(FOLLOW_aexpr_in_condExpr1471);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 175:28: -> or(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("or",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;
						case 9 :
							// Java.g:176:15: '&&' b= aexpr
							{
							match(input,9,FOLLOW_9_in_condExpr1501); 
							pushFollow(FOLLOW_aexpr_in_condExpr1505);
							b=aexpr();
							state._fsp--;

							// TEMPLATE REWRITE
							// 176:28: -> and(left=$a.stright=$b.st)
							{
								retval.st = templateLib.getInstanceOf("and",new STAttrMap().put("left", (a!=null?((StringTemplate)a.getTemplate()):null)).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
							}



							}
							break;

					}

					}
					break;
				case 2 :
					// Java.g:178:13: 
					{
					// TEMPLATE REWRITE
					// 178:13: -> {$a.st}
					{
						retval.st = (a!=null?((StringTemplate)a.getTemplate()):null);
					}



					}
					break;

			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "condExpr"


	public static class aexpr_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "aexpr"
	// Java.g:182:1: aexpr : (a= atom -> {$a.st}) ( '+' b= atom -> add(left=$aexpr.stright=$b.st))* ( '-' b= atom -> subtract(left=$aexpr.stright=$b.st))* ( '*' b= atom -> multiply(left=$aexpr.stright=$b.st))* ( '/' b= atom -> divide(left=$aexpr.stright=$b.st))* ( '%' b= atom -> modulo(left=$aexpr.stright=$b.st))* ;
	public final JavaParser.aexpr_return aexpr() throws RecognitionException {
		JavaParser.aexpr_return retval = new JavaParser.aexpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;

		try {
			// Java.g:183:5: ( (a= atom -> {$a.st}) ( '+' b= atom -> add(left=$aexpr.stright=$b.st))* ( '-' b= atom -> subtract(left=$aexpr.stright=$b.st))* ( '*' b= atom -> multiply(left=$aexpr.stright=$b.st))* ( '/' b= atom -> divide(left=$aexpr.stright=$b.st))* ( '%' b= atom -> modulo(left=$aexpr.stright=$b.st))* )
			// Java.g:183:9: (a= atom -> {$a.st}) ( '+' b= atom -> add(left=$aexpr.stright=$b.st))* ( '-' b= atom -> subtract(left=$aexpr.stright=$b.st))* ( '*' b= atom -> multiply(left=$aexpr.stright=$b.st))* ( '/' b= atom -> divide(left=$aexpr.stright=$b.st))* ( '%' b= atom -> modulo(left=$aexpr.stright=$b.st))*
			{
			// Java.g:183:9: (a= atom -> {$a.st})
			// Java.g:183:10: a= atom
			{
			pushFollow(FOLLOW_atom_in_aexpr1582);
			a=atom();
			state._fsp--;

			// TEMPLATE REWRITE
			// 183:17: -> {$a.st}
			{
				retval.st = (a!=null?((StringTemplate)a.getTemplate()):null);
			}



			}

			// Java.g:184:9: ( '+' b= atom -> add(left=$aexpr.stright=$b.st))*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==13) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// Java.g:184:11: '+' b= atom
					{
					match(input,13,FOLLOW_13_in_aexpr1599); 
					pushFollow(FOLLOW_atom_in_aexpr1603);
					b=atom();
					state._fsp--;

					// TEMPLATE REWRITE
					// 184:22: -> add(left=$aexpr.stright=$b.st)
					{
						retval.st = templateLib.getInstanceOf("add",new STAttrMap().put("left", retval.st).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
					}



					}
					break;

				default :
					break loop13;
				}
			}

			// Java.g:185:9: ( '-' b= atom -> subtract(left=$aexpr.stright=$b.st))*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==16) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// Java.g:185:11: '-' b= atom
					{
					match(input,16,FOLLOW_16_in_aexpr1632); 
					pushFollow(FOLLOW_atom_in_aexpr1636);
					b=atom();
					state._fsp--;

					// TEMPLATE REWRITE
					// 185:22: -> subtract(left=$aexpr.stright=$b.st)
					{
						retval.st = templateLib.getInstanceOf("subtract",new STAttrMap().put("left", retval.st).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
					}



					}
					break;

				default :
					break loop14;
				}
			}

			// Java.g:186:9: ( '*' b= atom -> multiply(left=$aexpr.stright=$b.st))*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==12) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// Java.g:186:11: '*' b= atom
					{
					match(input,12,FOLLOW_12_in_aexpr1665); 
					pushFollow(FOLLOW_atom_in_aexpr1669);
					b=atom();
					state._fsp--;

					// TEMPLATE REWRITE
					// 186:22: -> multiply(left=$aexpr.stright=$b.st)
					{
						retval.st = templateLib.getInstanceOf("multiply",new STAttrMap().put("left", retval.st).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
					}



					}
					break;

				default :
					break loop15;
				}
			}

			// Java.g:187:9: ( '/' b= atom -> divide(left=$aexpr.stright=$b.st))*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==19) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// Java.g:187:11: '/' b= atom
					{
					match(input,19,FOLLOW_19_in_aexpr1698); 
					pushFollow(FOLLOW_atom_in_aexpr1702);
					b=atom();
					state._fsp--;

					// TEMPLATE REWRITE
					// 187:22: -> divide(left=$aexpr.stright=$b.st)
					{
						retval.st = templateLib.getInstanceOf("divide",new STAttrMap().put("left", retval.st).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
					}



					}
					break;

				default :
					break loop16;
				}
			}

			// Java.g:188:9: ( '%' b= atom -> modulo(left=$aexpr.stright=$b.st))*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==8) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// Java.g:188:11: '%' b= atom
					{
					match(input,8,FOLLOW_8_in_aexpr1731); 
					pushFollow(FOLLOW_atom_in_aexpr1735);
					b=atom();
					state._fsp--;

					// TEMPLATE REWRITE
					// 188:22: -> modulo(left=$aexpr.stright=$b.st)
					{
						retval.st = templateLib.getInstanceOf("modulo",new STAttrMap().put("left", retval.st).put("right", (b!=null?((StringTemplate)b.getTemplate()):null)));
					}



					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aexpr"


	public static class atom_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "atom"
	// Java.g:192:1: atom : ( ID -> refVar(id=$ID.text)| INT -> iconst(value=$INT.text)| '(' expr ')' -> {$expr.st});
	public final JavaParser.atom_return atom() throws RecognitionException {
		JavaParser.atom_return retval = new JavaParser.atom_return();
		retval.start = input.LT(1);

		Token ID23=null;
		Token INT24=null;
		ParserRuleReturnScope expr25 =null;

		try {
			// Java.g:193:5: ( ID -> refVar(id=$ID.text)| INT -> iconst(value=$INT.text)| '(' expr ')' -> {$expr.st})
			int alt18=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt18=1;
				}
				break;
			case INT:
				{
				alt18=2;
				}
				break;
			case 10:
				{
				alt18=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// Java.g:193:7: ID
					{
					ID23=(Token)match(input,ID,FOLLOW_ID_in_atom1770); 
					// TEMPLATE REWRITE
					// 193:10: -> refVar(id=$ID.text)
					{
						retval.st = templateLib.getInstanceOf("refVar",new STAttrMap().put("id", (ID23!=null?ID23.getText():null)));
					}



					}
					break;
				case 2 :
					// Java.g:194:7: INT
					{
					INT24=(Token)match(input,INT,FOLLOW_INT_in_atom1787); 
					// TEMPLATE REWRITE
					// 194:11: -> iconst(value=$INT.text)
					{
						retval.st = templateLib.getInstanceOf("iconst",new STAttrMap().put("value", (INT24!=null?INT24.getText():null)));
					}



					}
					break;
				case 3 :
					// Java.g:195:7: '(' expr ')'
					{
					match(input,10,FOLLOW_10_in_atom1804); 
					pushFollow(FOLLOW_expr_in_atom1806);
					expr25=expr();
					state._fsp--;

					match(input,11,FOLLOW_11_in_atom1808); 
					// TEMPLATE REWRITE
					// 195:20: -> {$expr.st}
					{
						retval.st = (expr25!=null?((StringTemplate)expr25.getTemplate()):null);
					}



					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_declaration_in_program47 = new BitSet(new long[]{0x000003FF38000012L});
	public static final BitSet FOLLOW_variable_in_declaration88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_declaration104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_variable129 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_declarator_in_variable131 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_variable133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_declarator207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modifier_in_function244 = new BitSet(new long[]{0x0000000110000010L});
	public static final BitSet FOLLOW_type_in_function246 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_function248 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_function260 = new BitSet(new long[]{0x0000000110000810L});
	public static final BitSet FOLLOW_formalParameter_in_function266 = new BitSet(new long[]{0x0000000000008800L});
	public static final BitSet FOLLOW_15_in_function270 = new BitSet(new long[]{0x0000000110000010L});
	public static final BitSet FOLLOW_formalParameter_in_function274 = new BitSet(new long[]{0x0000000000008800L});
	public static final BitSet FOLLOW_11_in_function282 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_block_in_function292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_formalParameter418 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_declarator_in_formalParameter420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_modifier468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_modifier478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_modifier488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_modifier498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_modifier508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_modifier518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_modifier528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_modifier538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_modifier548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_modifier558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_modifier568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_type587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_type604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_block651 = new BitSet(new long[]{0x00002C01D0100430L});
	public static final BitSet FOLLOW_variable_in_block662 = new BitSet(new long[]{0x00002C01D0100430L});
	public static final BitSet FOLLOW_stat_in_block678 = new BitSet(new long[]{0x00002C00C0100430L});
	public static final BitSet FOLLOW_45_in_block691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forStat_in_stat718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStat_in_stat731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStat_in_stat744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_stat756 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_stat758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat775 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignStat_in_stat797 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_stat799 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_stat811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_forStat845 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_forStat847 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_assignStat_in_forStat851 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_forStat853 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_condExpr_in_forStat857 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_forStat859 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_assignStat_in_forStat863 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_forStat865 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_block_in_forStat867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_whileStat950 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_whileStat952 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_expr_in_whileStat955 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_whileStat957 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_block_in_whileStat959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_ifStat1033 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ifStat1035 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_expr_in_ifStat1038 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_ifStat1040 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_block_in_ifStat1042 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignStat1108 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_assignStat1110 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_expr_in_assignStat1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignStat1136 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_assignStat1138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_assignStat1158 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_assignStat1160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_condExpr_in_expr1184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1209 = new BitSet(new long[]{0x0000100007640282L});
	public static final BitSet FOLLOW_24_in_condExpr1226 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_7_in_condExpr1260 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_condExpr1296 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_condExpr1331 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1334 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_condExpr1336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_condExpr1365 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_condExpr1399 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_condExpr1433 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_condExpr1467 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_condExpr1501 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_aexpr_in_condExpr1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_aexpr1582 = new BitSet(new long[]{0x0000000000093102L});
	public static final BitSet FOLLOW_13_in_aexpr1599 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_atom_in_aexpr1603 = new BitSet(new long[]{0x0000000000093102L});
	public static final BitSet FOLLOW_16_in_aexpr1632 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_atom_in_aexpr1636 = new BitSet(new long[]{0x0000000000091102L});
	public static final BitSet FOLLOW_12_in_aexpr1665 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_atom_in_aexpr1669 = new BitSet(new long[]{0x0000000000081102L});
	public static final BitSet FOLLOW_19_in_aexpr1698 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_atom_in_aexpr1702 = new BitSet(new long[]{0x0000000000080102L});
	public static final BitSet FOLLOW_8_in_aexpr1731 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_atom_in_aexpr1735 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_ID_in_atom1770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_atom1787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_atom1804 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_expr_in_atom1806 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_atom1808 = new BitSet(new long[]{0x0000000000000002L});
}
