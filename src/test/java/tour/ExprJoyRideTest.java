package tour;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExprJoyRideTest {

    @Test
    public void test_main() throws Exception {
        List<String> argList = new ArrayList<String>();
        argList.add("./src/test/fixture/tour/t.expr");
        String[] args = new String[argList.size()];
        args = argList.toArray(args);
        ExprJoyRide.main(args);
    }
}
