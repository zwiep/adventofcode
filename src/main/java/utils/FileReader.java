package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    public ArrayList readIntegerFile(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        ArrayList<ArrayList> array = new ArrayList();
        String line;

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

    public ArrayList readStringFile(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        ArrayList<String> array = new ArrayList();
        String line;

        while ((line = read.readLine()) != null){
            array.add(line);
        }
        read.close();

        return array;
    }
}
