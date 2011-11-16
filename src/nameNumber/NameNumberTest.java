package nameNumber;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

    /**
     * 
     * @author yael Tochner
     *
     */

public class NameNumberTest {
    NameNumber number = new NameNumber();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testNumbersToWords() {
        String lineBefore = "On Nov 18th 2011 there will be 49 apples on the tree.";
        String lineAfter = "On Nov eighteenth two thousand eleven there will be forty nine apples on the tree.";
        assertEquals(lineAfter, number.numbersToWords(lineBefore));
        
        String lineBefore1 = "        The time is         10:41        ";
        String lineAfter1 = "The time is         ten:forty one";
        assertEquals(lineAfter1, number.numbersToWords(lineBefore1));

    }

    @Test
    public void testNameOf() {
        assertEquals("zero", number.nameOf(0));
        assertEquals("forty nine", number.nameOf(49));
        assertEquals("five hundred forty nine", number.nameOf(549));
        assertEquals("five hundred", number.nameOf(500));
        assertEquals("one thousand five hundred forty nine", number.nameOf(1549));
        assertEquals("one thousand four hundred sixteen", number.nameOf(1416));
    }

    @Test
    public void testNameOfDigit() {
        assertEquals("four", number.nameOfDigit(4));
        assertEquals("zero", number.nameOfDigit(0));
        //assertEquals(null, number.nameOfDigit(10));


    }

    @Test
    public void testNameOfTensDigit() {
        assertEquals("ten", number.nameOfTensDigit(1));
        assertEquals("forty", number.nameOfTensDigit(4));
        assertEquals("ninety", number.nameOfTensDigit(9));
        assertEquals(null, number.nameOfTensDigit(0));



    }

    @Test
    public void testNameOfTeens() {
        assertEquals("ten", number.nameOfTeens(10));
        assertEquals("nineteen", number.nameOfTeens(19));

    }

}
