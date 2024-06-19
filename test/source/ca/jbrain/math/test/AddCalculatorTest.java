package ca.jbrain.math.test;

import ca.jbrain.math.AddCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AddCalculatorTest {
    @Test
    public void returnZeroOnAnEmptyString() {
        assertEquals(0, AddCalculator.add(""));
    }

    @Test
    public void returnNonZeroWhenItHasOneNonZeroPara() {
        assertEquals(1,AddCalculator.add("1"));
    }

    @Test
    public void returnNonZeroWhenItHasTwoNonZeroPara() {
        assertEquals(3,AddCalculator.add("1,2"));
    }

    @Test
    public void returnNonZeroWhenItHasMultipleArguments() {
        assertEquals(5,AddCalculator.add("2,2,1"));
    }
}
