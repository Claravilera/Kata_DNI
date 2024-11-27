package TestModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import DNIModel.DNICalculator;

public class DNICalculatorTest {
    @Test
    void testCalculateLetter() {

        DNICalculator calculator = new DNICalculator();

        assertEquals('T', calculator.calculateLetter(0));
        assertEquals('R', calculator.calculateLetter(1));
        assertEquals('Y', calculator.calculateLetter(60598796));
        assertEquals('M', calculator.calculateLetter(44531823));
    }

     @Test
    public void testCalculateLetterOutOfRange() {
        DNICalculator calculator = new DNICalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateLetter(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateLetter(100000000);
        });
    }
}