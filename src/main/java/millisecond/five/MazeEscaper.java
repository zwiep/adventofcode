package millisecond.five;

import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class MazeEscaper {

    FileReader fileReader = new FileReader();

    public int mazeEscape(String fileLocation, boolean isPartOne) throws IOException {
        ArrayList<Integer> integerArray = fileReader.readSingleIntegersToArray(fileLocation);
        if (isPartOne) {
            return calculateAmountOfStepsForEscape(integerArray, true);
        } else {
            return calculateAmountOfStepsForEscape(integerArray, false);
        }
    }

    public int calculateAmountOfStepsForEscape(ArrayList<Integer> inputArray, boolean isForPartOne) {
        int currentIndex = 0;
        int nextIndex;
        int step = 0;
        if (isForPartOne) {
            while ((currentIndex < (inputArray.size()))  && (currentIndex >= 0)) {
                nextIndex = currentIndex + inputArray.get(currentIndex);
                inputArray.set(currentIndex, inputArray.get(currentIndex) + 1);
                currentIndex = nextIndex;
                step++;
            }
        } else {
            while ((currentIndex < (inputArray.size()))  && (currentIndex >= 0)) {
                nextIndex = currentIndex + inputArray.get(currentIndex);
                int currentValue = inputArray.get(currentIndex);
/*                if (currentValue <= -3 || (currentValue >= 0 && currentValue < 3)) {
                    inputArray.set(currentIndex, currentValue +1);
                } else {
                    inputArray.set(currentIndex, currentValue -1);
                }*/

                if (currentValue >= 3) {
                    inputArray.set(currentIndex, currentValue - 1);
                }
                else {
                    inputArray.set(currentIndex, currentValue + 1);
                }
                currentIndex = nextIndex;
                step++;
            }
        }
        return step;
    }
}
