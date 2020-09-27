package leoli.pattern.state.demo;


import junit.framework.TestCase;
import org.junit.Test;

public class TestStateDemo extends TestCase {

    @Test
    public void testStateDemo() {

        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();

    }

}