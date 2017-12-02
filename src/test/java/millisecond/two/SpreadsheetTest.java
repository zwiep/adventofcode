package millisecond.two;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SpreadsheetTest {

    /*
    5 1 9 5
    7 5 3
    2 4 6 8
    The first row's largest and smallest values are 9 and 1, and their difference is 8.
    The second row's largest and smallest values are 7 and 3, and their difference is 4.
    The third row's difference is 6.
    In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
     */

    private Spreadsheet spreadsheet = new Spreadsheet();

    @Test
    public void readFile_returnsArrayWithRightNumbers() throws Exception {
        String fileLocation = "src/test/resources/input_rows_test";
        ArrayList<Integer> rowOne = new ArrayList();
        rowOne.add(5);
        rowOne.add(1);
        rowOne.add(9);
        rowOne.add(5);
        ArrayList<Integer> rowTwo = new ArrayList();
        rowTwo.add(7);
        rowTwo.add(5);
        rowTwo.add(3);
        ArrayList<Integer> rowThree = new ArrayList();
        rowThree.add(2);
        rowThree.add(4);
        rowThree.add(6);
        rowThree.add(8);
        ArrayList<ArrayList> expectedArray = new ArrayList();
        expectedArray.add(rowOne);
        expectedArray.add(rowTwo);
        expectedArray.add(rowThree);

        ArrayList<ArrayList> actualArray = spreadsheet.readFile(fileLocation);

        Assertions.assertThat(actualArray).isEqualTo(expectedArray);
    }

    @Test
    public void arrayInput_returnsRightReuslt() throws Exception {
        String fileLocation = "src/test/resources/input_rows_test";

        int result = spreadsheet.checksum(fileLocation);

        Assertions.assertThat(result).isEqualTo(18);
    }
}