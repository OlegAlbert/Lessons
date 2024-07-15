import org.example.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.computeFactorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, Factorial.computeFactorial(1));
    }

    @Test
    public void testFactorialOfTwo() {
        assertEquals(2, Factorial.computeFactorial(2));
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, Factorial.computeFactorial(5));
    }

    @Test
    public void testFactorialOfLargeNumber() {
        assertEquals(3628800, Factorial.computeFactorial(10));
    }

    @Test
    public void testFactorialOfVeryLargeNumber() {
        assertEquals(2432902008176640000L, Factorial.computeFactorial(20));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Factorial.computeFactorial(-1));
        assertEquals("Number must be non-negative", exception.getMessage());
    }

    // тест очень долго считает, в итоге выкидывает исключение. Тест проходит
    /*@Test
    public void testFactorialOfMaxInt() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Factorial.computeFactorial(Integer.MAX_VALUE);
        });
        assertTrue(exception.getMessage().contains("long overflow"));
    }*/
}
