package millisecond.five;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeEscaperTest {

    MazeEscaper mazeEscaper = new MazeEscaper();

    /*
    For example, consider the following list of jump offsets:

    0
    3
    0
    1
    -3
    Positive jumps ("forward") move downward; negative jumps move upward. For legibility in this example, these offset values will be written all on one line, with the current instruction marked in parentheses. The following steps would be taken before an exit is found:

    (0) 3  0  1  -3  - before we have taken any steps.
    (1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1.
     2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2.
     2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind.
     2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2.
     2  5  0  1  -2  - jump 4 steps forward, escaping the maze.
    In this example, the exit is reached in 5 steps.
     */

    @Test
    public void mazeEscapePartOne_returnsFive() {
        ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,3,0,1,-3));
        boolean isForPartOne = true;
        int expectedAmountOfSteps = 5;
        int resultAmountOfSteps = mazeEscaper.calculateAmountOfStepsForEscape(inputArray, isForPartOne);

        Assertions.assertThat(resultAmountOfSteps).isEqualTo(expectedAmountOfSteps);
    }

    @Test
    public void mazeEscapePartTwo_returnsTen() {
        ArrayList<Integer> inputArray = new ArrayList<>(Arrays.asList(0,3,0,1,-3));
        boolean isForPartOne = false;
        int expectedAmountOfSteps = 10;
        int resultAmountOfSteps = mazeEscaper.calculateAmountOfStepsForEscape(inputArray, isForPartOne);

        Assertions.assertThat(resultAmountOfSteps).isEqualTo(expectedAmountOfSteps);
    }
}