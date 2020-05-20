package tour;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Paths;

public class CalcTest {

    @Test
    public void test_smoke() throws Exception {
        String expr = this.makeExpr();
        System.out.println(String.format("expr=%s", expr));
        Calc calc = new Calc();
        calc.setReader(new StringReader(expr));
        calc.execute();
    }

    private String makeExpr() throws IOException {
        File t = Paths.get("src/test/fixture/tour/t.expr").toFile();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(t), "utf-8")
        );
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
