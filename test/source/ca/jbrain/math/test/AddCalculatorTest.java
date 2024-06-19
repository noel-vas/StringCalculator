package ca.jbrain.math.test;

import ca.jbrain.math.AddCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AddCalculatorTest {
    @Test
    public void ReturnZeroOnEmptyString() {
        assertEquals(0, AddCalculator.add(""));
    }
}
