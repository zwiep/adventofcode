package millisecond.two;

import org.fest.assertions.Assertions;
import org.fest.util.Arrays;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class SpreadsheetTest {

    private Spreadsheet spreadsheet = new Spreadsheet();

    /*
    5 1 9 5
    7 5 3
    2 4 6 8
    The first row's largest and smallest values are 9 and 1, and their difference is 8.
    The second row's largest and smallest values are 7 and 3, and their difference is 4.
    The third row's difference is 6.
    In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
     */

    @Test
    public void readFile_returnsArrayWithRightNumbers() throws Exception {
        String fileLocation = "src/test/resources/input_rows_test_checksum_one";
        ArrayList<ArrayList> expectedArray = createExpectedArrayForChecksumOne();

        ArrayList<ArrayList> actualArray = spreadsheet.readFile(fileLocation);

        Assertions.assertThat(actualArray).isEqualTo(expectedArray);
    }

    @Test
    public void arrayInput_returnsRightReuslt() throws Exception {
        String fileLocation = "src/test/resources/input_rows_test_checksum_one";

        int result = spreadsheet.checksum(fileLocation);

        Assertions.assertThat(result).isEqualTo(18);
    }

    /*
    5 9 2 8
    9 4 7 3
    3 8 6 5
    In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
    In the second row, the two numbers are 9 and 3; the result is 3.
    In the third row, the result is 2.
    In this example, the sum of the results would be 4 + 3 + 2 = 9.
     */

    @Test
    public void checksumTwo_returnsRightResult() throws Exception {
        String fileLocation = "src/test/resources/input_rows_test_checksum_two";

        int result = spreadsheet.checksumTwo(fileLocation);

        Assertions.assertThat(result).isEqualTo(9);

    }

    private ArrayList<ArrayList> createExpectedArrayForChecksumTwo() {
        ArrayList<ArrayList> expectedArray = new ArrayList<>(
                asList(
                    new ArrayList<>(asList(5, 9, 2, 8)),
                    new ArrayList<>(asList(9, 4, 7, 3)),
                    new ArrayList<>(asList(3, 8, 6, 5))
                )
        );
        return expectedArray;
    }

    private ArrayList<ArrayList> createExpectedArrayForChecksumOne() {

        ArrayList<ArrayList> expectedArray = new ArrayList<>(
                asList(
                        new ArrayList<>(asList(5, 1, 9, 5)),
                        new ArrayList<>(asList(7, 5, 3)),
                        new ArrayList<>(asList(2, 4, 6, 8))
                )
        );
        return expectedArray;
    }
}