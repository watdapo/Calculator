package swew17.at.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    @Test
    public void testAdd() {

        int result = Calculator.add(7, 8);

        assertEquals(15, result);
    }

    @Test
    public void testSub() {

        int result = Calculator.sub(42, 48);

        assertEquals(-6, result);
    }

    @Test
    public void testMul() {

        int result = Calculator.mul(8, 8);

        assertEquals(64, result);
    }

    @Test
    public void testDiv() {

        int result = Calculator.div(14, 7);

        assertEquals(2, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivByZero() {

        int result = Calculator.div(3, 0);

        assertEquals(15, result);
    }

}