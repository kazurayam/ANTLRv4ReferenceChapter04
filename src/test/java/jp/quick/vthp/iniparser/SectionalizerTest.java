package jp.quick.vthp.iniparser;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertTrue;

public class SectionalizerTest {

    @Test
    public void test_sectionalize() throws IOException {
        Reader reader = new StringReader(FixtureFactory.fixtureNoSection());
        String content = Sectionalizer.sectionalize(reader);
        assertTrue(content, content.startsWith("[?]"));
    }

    @Test
    public void test_sectionalizeSampleFile() throws IOException {
        File sample = new File("./src/test/fixture/iniparser/sample.ctl");
        Reader reader = new InputStreamReader(
                new FileInputStream(sample), "UTF-8");
        String content = Sectionalizer.sectionalize(reader);
        assertTrue(content, content.startsWith("[?]"));
    }
}
