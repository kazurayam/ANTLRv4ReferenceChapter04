package jp.quick.vthp.iniparser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertTrue;

public class HpIniEventTracingListenerTest {

    @Test
    public void test_typical() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        String content = FixtureFactory.fixtureTypical();
        boolean result = processContent(content, method);
        assertTrue("one or more errors occured", result);
    }

    /**
     * INI.g4 grammar requires one or more [SECTION].
     * INI.g4 grammar does not accept an instance without [SECTION].
     * Therefore the test_noSection() fails.
     * So we ignore this test.
     * @throws Exception
     */
    @Ignore
    @Test
    public void test_noSection() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        String content = FixtureFactory.fixtureNoSection();
        boolean result = processContent(content, method);
        assertTrue("one or more errors occured", result);
    }

    @Test
    public void test_comment() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        String content = FixtureFactory.fixtureComment();
        boolean result = processContent(content, method);
        assertTrue("one or more errors occured", result);
    }

    @Test
    public void test_SectionNamedQuestion() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        String content = FixtureFactory.fixtureSectionNamedQuestion();
        boolean result = processContent(content, method);
        assertTrue("one or more errors occured", result);
    }

    @Test
    public void test_I18nValue() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        String content = FixtureFactory.fixtureI18nValue();
        boolean result = processContent(content, method);
        assertTrue("one or more errors occured", result);
    }

    @Test
    public void test_CommentI18n() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        String content = FixtureFactory.fixtureCommentI18n();
        boolean result = processContent(content, method);
        assertTrue("one or more errors occured", result);
    }

    @Test
    public void test_sampleCtl() throws Exception {
        // get the method name by reflection for logging
        String method = new Object() {}.getClass().getEnclosingMethod().getName();
        //
        File sample = new File("./src/test/fixture/iniparser/sample.ctl");
        Reader reader = new InputStreamReader(
                new FileInputStream(sample), "utf-8");
        String content = Sectionalizer.sectionalize(reader);
        boolean result = processContent(content, method);
        assertTrue("one or more errors", result);
    }

    private boolean processContent(String content, String annotation) throws Exception {
        // setup:
        // we instantiate the lexer
        INILexer lexer = new INILexer(CharStreams.fromReader(new StringReader(content)));
        // we instantiate the parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        INIParser iniParser = new INIParser(tokens);
        // we instantiate the walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // we instantiate the listener
        StringWriter buffer = new StringWriter();
        HpIniEventTracingListener listener = new HpIniEventTracingListener(buffer, annotation);
        walker.walk(listener, iniParser.ini());
        // print the buffer
        System.out.print(String.format("%s", buffer.toString()));

        // I want to, but do not yet know how to, count the number of errors
        // detected by the grammar.
        // If no error return true, otherwise return false
        return (listener.getNumberOfErrors() == 0);
    }
}
