import org.example.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.computeFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.computeFactorial(1), 1);
    }

    @Test
    public void testFactorialOfTwo() {
        assertEquals(Factorial.computeFactorial(2), 2);
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.computeFactorial(5), 120);
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(Factorial.computeFactorial(10), 3628800);
    }

    @Test
    public void testFactorialOfVeryLargeNumber() {
        assertEquals(Factorial.computeFactorial(20), 2432902008176640000L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be non-negative")
    public void testFactorialOfNegativeNumber() {
        Factorial.computeFactorial(-1);
    }

    /*@Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "long overflow")
    public void testFactorialOfMaxInt() {
        Factorial.computeFactorial(Integer.MAX_VALUE);
    }*/
}