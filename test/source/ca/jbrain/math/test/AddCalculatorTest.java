package ca.jbrain.math.test;

import ca.jbrain.math.AddCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class AddCalculatorTest {
    @Test
    public void returnZeroOnAnEmptyString() {
        assertEquals("0", AddCalculator.add(""));
    }

    @Test
    public void returnNonZeroWhenItHasOneNonZeroPara() {
        assertEquals("1",AddCalculator.add("1"));
    }

    @Test
    public void returnNonZeroWhenItHasTwoNonZeroPara() {
        assertEquals("6",AddCalculator.add("1,2,3"));
    }

    @Test
    public void returnNonZeroWhenItHasMultipleArguments() {
        assertEquals("7",AddCalculator.add("2,2,1,2"));
    }

    @Test
    public void AcceptNewlineAsASeparatorAlongWithCommas() {
        assertEquals("10",AddCalculator.add("2,3\n2\n3"));
    }

    @Test
    public void InvalidSeparatorPosition() {
            assertEquals("Number expected but found ',' at position 4.", AddCalculator.add("2,3,,2"));
    }

    @Test
    public void MissingNumberInLastPosition() {
            assertEquals( "Number expected but EOF found",AddCalculator.add("1,3,4,5,"));
    }

    @Test
    public void HandlesDifferentDelimiters() {
        assertEquals("3",AddCalculator.add("//|\n1|2"));
    }

    @Test
    public void ReturnAnInvalidMessageWhenTheActualDelimiterIsNotPresentInCaseOfCustomSeparator() {
        assertEquals("'|' expected but ',' found at position 3.",AddCalculator.add("//|\n1|2,3"));
    }

    @Test
    public void ReturnAMessageWhenTheStringHasNegativeNumbers() {
        assertEquals("Negative not allowed : -1,-2,-3",AddCalculator.add("-1,-2,-3"));
    }

    @Test
    public void MultipleErrors() {
        assertEquals( "Number expected but found ',' at position 3.\nNegative not allowed : -1",AddCalculator.add("-1,,2"));
    }

    @Test
    public void ThrowAnInvalidExceptionDuringNullString() {
        assertThrows(IllegalArgumentException.class,() -> AddCalculator.add(null));
    }
}
