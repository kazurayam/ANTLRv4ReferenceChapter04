package tour;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExprJoyRide {

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        CharStream input = CharStreams.fromReader(new InputStreamReader(is, "utf-8"));
        // we instantiate the lexer
        ExprLexer lexer = new ExprLexer(input);
        // we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        //
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }

}
