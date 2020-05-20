package tour;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Calc {

    private Reader reader;

    public Calc() {

    }

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        Calc calc = new Calc();
        calc.setReader(new InputStreamReader(is,"utf-8"));
        calc.execute();
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void execute() throws Exception {
        validateParams();
        CharStream input = CharStreams.fromReader(reader);
        // we instantiate the lexer
        LabeledExprLexer lexer = new LabeledExprLexer(input);
        // we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        // we do parse
        ParseTree tree = parser.prog();
        // now, we visit the tree
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }

    private void validateParams() throws Exception {
        if (reader == null) {
            throw new IllegalStateException("this.reader is null. you need to do setInputStream(is)");
        }
    }
}
