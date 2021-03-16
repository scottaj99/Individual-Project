import java.io.*;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class Main {
    public static StringTemplateGroup templates;

    public static void main(String[] args) throws Exception {
	String templateFileName;
	int a = 0;
	if ( args.length<=1 ) {
		templateFileName = "Python.stg";
	}
	else {
		templateFileName = args[a];
		a++;
	}
	templates = new StringTemplateGroup(new FileReader(templateFileName),
					    AngleBracketTemplateLexer.class);

	CharStream input = new ANTLRFileStream(args[a]);
	JavaGrammarLexer lexer = new JavaGrammarLexer(input);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	JavaGrammarParser parser = new JavaGrammarParser(tokens);
	parser.setTemplateLib(templates);
	RuleReturnScope r = parser.compilationUnit();
	System.out.println(r.getTemplate().toString());
	a++;
	if (args.length > a ){
		PrintWriter out = new PrintWriter(args[a]);
		out.println(r.getTemplate().toString());
		out.close();
	}
    }
}
