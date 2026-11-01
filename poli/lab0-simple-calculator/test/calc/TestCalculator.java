package calc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestCalculator {

    @Test
    void testSum(){
        double a = 4.5;
        double b = 3.5;

        double result = Calculator.compute(Calculator.SUM, a, b);

        assertEquals(a+b, result, 0.01, "Wrong sum result");
    }

    @Test
    void testSub(){
        double a = 4.5;
        double b = 3.5;

        double result = Calculator.compute(Calculator.SUB, a, b);

        assertEquals(a-b, result, 0.01, "Wrong subtraction result");
    }

    @Test
    void testMul(){
        double a = 4.5;
        double b = 3.5;

        double result = Calculator.compute(Calculator.MUL, a, b);

        assertEquals(a*b, result, 0.01, "Wrong subtraction result");
    }

    @Test
    void testDiv(){
        double a = 4.5;
        double b = 1.5;

        double result = Calculator.compute(Calculator.DIV, a, b);

        assertEquals(a/b, result, 0.01, "Wrong subtraction result");
    }

    @Test
    void testDivByZero(){
        double a = 4.5;
        double b = 0;

        Calculator.compute(Calculator.DIV, a, b);

        assertTrue(Calculator.error, "Division by zero should give an error");
    }

    @Test
    void testWrongOp(){
        double a = 1;
        double b = 1;

        Calculator.compute(999, a, b);

        assertTrue(Calculator.error, "Wrong operation should give an error");
    }
}
