package Day_17;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitAnnotationsExample.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Result=="+result.wasSuccessful());
    }

    @Test
    void assertEquals(boolean expected, boolean actual){
        return;
    }

    void assertFalse(boolean condition){
        return;
    }

    void assertNotNull(Object object){
        return;
    }

}
