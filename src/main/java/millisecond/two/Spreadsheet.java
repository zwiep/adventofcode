package millisecond.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Spreadsheet {

    public int checksum(String fileLocation) throws IOException {
        ArrayList<ArrayList> inputArray = readFile(fileLocation);
        int checksum = 0;
        for (ArrayList<Integer> row : inputArray) {
            Collections.sort(row);
            Collections.reverse(row);
            int difference = row.get(0) - row.get(row.size()-1);
            checksum = checksum + difference;
        }
        return checksum;
    }

    public int checksumTwo(String fileLocation) {
        return 99;
    }

    public ArrayList readFile(String fileLocation) throws IOException {

        BufferedReader read = new BufferedReader(new FileReader(fileLocation));

        ArrayList<ArrayList> array = new ArrayList();

        String line = null;

        while ((line = read.readLine()) != null){
            ArrayList<Integer> lineArray = new ArrayList();
            String[] values = line.split("\\s+");
            for (String value: values) {
                lineArray.add(Integer.valueOf(value));
            }
            array.add(lineArray);

        }
        read.close();

        return array;
    }
}
