package ca.jbrain.math.test;

import ca.jbrain.math.AddCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
        assertEquals("3",AddCalculator.add("1,2"));
    }

    @Test
    public void returnNonZeroWhenItHasMultipleArguments() {
        assertEquals("5",AddCalculator.add("2,2,1"));
    }

    @Test
    public void AcceptNewlineAsASeparatorAlongWithCommas() {
        assertEquals("7",AddCalculator.add("2,3\n2"));
    }

    @Test
    public void InvalidSeparatorPosition() {
            assertEquals("Number expected but found '\\n' at position 4", AddCalculator.add("2,3,\n2"));
    }

    @Test
    public void MissingNumberInLastPosition() {
            assertEquals( "Number expected but EOF found",AddCalculator.add("1,3,4,"));
    }

    @Test
    public void HandlesDifferentDelimiters() {
        assertEquals("3",AddCalculator.add("//sep\n1sep2"));
    }

    @Test
    public void ReturnAnInvalidMessageWhenTheActualDelimiterIsNotPresentInCaseOfCustomSeparator() {
        assertEquals("'|' expected but ',' found at position 3.",AddCalculator.add("//|\n1|2,3"));
    }

    
}
