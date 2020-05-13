package jp.quick.vthp.iniparser;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HpIniProcessorTest {

    @Test
    public void test_process_simpleFixture_withMyIniListener() throws IOException {
        String content = FixtureFactory.fixtureTypical();
        // setup:
        HpIniProcessor processor = new HpIniProcessor();
        processor.setInput(new StringReader(content));
        StringWriter sw = new StringWriter();
        HpIniEventTracingListener listener = new HpIniEventTracingListener(sw);
        processor.setINIListener(listener);
        // when:
        processor.process();
        String result = sw.toString();
        // then:
        assertTrue(result.length() > 0);
        assertTrue(result, result.contains("DATABASE"));
    }

}
