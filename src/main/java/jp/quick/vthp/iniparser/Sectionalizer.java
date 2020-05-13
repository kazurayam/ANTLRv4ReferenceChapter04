package jp.quick.vthp.iniparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Sectionalizer {

    private Sectionalizer() {}

    /**
     * prepend a string of "[?]\n" (which is a SECTION in INI format)
     * to the string read from the source. This makes a SECTION-less
     * INI file can be parsed by our INI.g4 grammar.
     *
     * @param source
     * @return
     */
    public static String sectionalize(Reader source) throws IOException {
       StringBuilder sb = new StringBuilder();
       sb.append("[?]\n");
       BufferedReader br = new BufferedReader(source);
       String s;
       while ((s = br.readLine()) != null) {
           sb.append(s);
           sb.append("\n");
       }
       return sb.toString();
    }
}
