package ca.jbrain.math.test;

import ca.jbrain.math.AddCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AddCalculatorTest {
    @Test
    public void ReturnZeroOnAnEmptyString() {
        assertEquals(0, AddCalculator.add(""));
    }

    @Test
    public void ReturnNonZeroWhenItHasOneNonZeroPara() {
        assertEquals(1,AddCalculator.add("1"));
    }

    @Test
    public void ReturnNonZeroWhenItHasTwoNonZeroPara() {
        assertEquals(2,AddCalculator.add("1,1"));
    }
}
