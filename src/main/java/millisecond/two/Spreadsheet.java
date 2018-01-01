package millisecond.two;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Spreadsheet {

    private utils.FileReader filereader = new utils.FileReader();

    public int checksum(String fileLocation) throws IOException {
        ArrayList<ArrayList> inputArray = filereader.readIntegerFile(fileLocation);
        int checksum = 0;

        for (ArrayList<Integer> row : inputArray) {
            Collections.sort(row);
            Collections.reverse(row);
            int difference = row.get(0) - row.get(row.size()-1);
            checksum = checksum + difference;
        }

        return checksum;
    }

    public int checksumTwo(String fileLocation) throws IOException {
        ArrayList<ArrayList> inputArray = filereader.readIntegerFile(fileLocation);
        int checksum = 0;

        for (ArrayList<Integer> row : inputArray) {
            for (Integer number : row) {
                for (Integer otherNumber : row) {
                    if ((number % otherNumber == 0) && (number != otherNumber)){
                            checksum = checksum + (number / otherNumber);
                        }
                    }
                }
            }

        return checksum;
    }
}
