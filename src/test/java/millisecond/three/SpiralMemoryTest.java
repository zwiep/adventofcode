package millisecond.three;

import org.fest.assertions.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@Ignore
public class SpiralMemoryTest {

    private SpiralMemory spiralMemory = new SpiralMemory();

    /*
    Data from square 1 is carried 0 steps, since it's at the access port.
    Data from square 12 is carried 3 steps, such as: down, left, left.
    Data from square 23 is carried only 2 steps: up twice.
    Data from square 1024 must be carried 31 steps.
     */

    @Test
    public void dataFromSquareOne_carriedZeroSteps() throws Exception {
        int result = spiralMemory.stepsToAccessPort(1);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void dataFromSquareTwelve_carriedThreeSteps() throws Exception {
        int result = spiralMemory.stepsToAccessPort(12);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void dataFromSquareTwentyThree_carriedTwoSteps() throws Exception {
        int result = spiralMemory.stepsToAccessPort(23);
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void dataFromSquareOneThousandAndTwentyFour_carriedThirtyOneSteps() throws Exception {
        int result = spiralMemory.stepsToAccessPort(1024);
        Assertions.assertThat(result).isEqualTo(31);
    }

    @Ignore
    @Test
    public void createSpiralArray_createsCorrectArraysForInputTwentyFive() {
        ArrayList<ArrayList> expectedArray = new ArrayList<>(
                asList(
                        new ArrayList<>(asList(17,16,15,14,13)),
                        new ArrayList<>(asList(18,5,4,3,12)),
                        new ArrayList<>(asList(19,6,1,2,11)),
                        new ArrayList<>(asList(20,7,8,9,10)),
                        new ArrayList<>(asList(21,22,23,24,25))
                )
        );
        ArrayList<ArrayList> actualSpiralArray = spiralMemory.createSpiralArray(25);
        Assertions.assertThat(actualSpiralArray).isEqualTo(expectedArray);
    }

    @Ignore
    @Test
    public void createSpiralArray_createsCorrectArraysForInputFourteen() {
        ArrayList<ArrayList> expectedArray = new ArrayList<>(
                asList(
                        new ArrayList<>(asList(14,13)),
                        new ArrayList<>(asList(5,4,3,12)),
                        new ArrayList<>(asList(6,1,2,11)),
                        new ArrayList<>(asList(7,8,9,10))
                )
        );
        ArrayList<ArrayList> actualSpiralArray = spiralMemory.createSpiralArray(14);

        Assertions.assertThat(actualSpiralArray).isEqualTo(expectedArray);
    }

    @Ignore
    @Test
    public void createSpiralArray_createsCorrectArraysForInputFiftyThree() {
        ArrayList<ArrayList> expectedArray = new ArrayList<>(
                asList(
                        new ArrayList<>(asList(37,36,35,34,33,32,31)),
                        new ArrayList<>(asList(38,17,16,15,14,13,30)),
                        new ArrayList<>(asList(39,18,5,4,3,12,29)),
                        new ArrayList<>(asList(40,19,6,1,2,11,28,53)),
                        new ArrayList<>(asList(41,20,7,8,9,10,27,52)),
                        new ArrayList<>(asList(42,21,22,23,24,25,26,51)),
                        new ArrayList<>(asList(43,44,45,46,47,48,49,50))
                )
        );
        ArrayList<ArrayList> actualSpiralArray = spiralMemory.createSpiralArray(53);

        Assertions.assertThat(actualSpiralArray).isEqualTo(expectedArray);
    }
}