package utils;

import millisecond.seven.Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    public ArrayList readIntegerFile(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        ArrayList<ArrayList> array = new ArrayList();
        String line;

        while ((line = read.readLine()) != null) {
            ArrayList<Integer> lineArray = new ArrayList();
            String[] values = line.split("\\s+");
            for (String value : values) {
                lineArray.add(Integer.valueOf(value));
            }
            array.add(lineArray);
        }
        read.close();

        return array;
    }

    public ArrayList<Integer> readLineToIntegerArray(String line) {
        ArrayList<Integer> array = new ArrayList<>();
        String[] values = line.split("\\s+");
        for (String value : values) {
            array.add(Integer.valueOf(value));
        }
        return array;
    }

    public ArrayList readStringFile(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        ArrayList<String> array = new ArrayList();
        String line;

        while ((line = read.readLine()) != null) {
            array.add(line);
        }
        read.close();

        return array;
    }

    public ArrayList readSingleIntegersToArray(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        ArrayList<Integer> array = new ArrayList();
        String line;

        while ((line = read.readLine()) != null) {
            array.add(Integer.valueOf(line));
        }
        read.close();

        return array;
    }

    public Program readLineToProgram(String line) {
        Program program = new Program();
        program.setWeight(Integer.valueOf(line.substring(line.indexOf("(") + 1, line.indexOf(")"))));
        program.setName(line.substring(0, line.indexOf("(")).trim());
        program.setProgramsOnDisc(readProgramNamesToArray(line));

        return program;
    }

    public ArrayList<Program> readFiletoArrayOfPrograms(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        ArrayList<Program> programArray = new ArrayList<>();

        String programLine;

        while ((programLine = read.readLine()) != null) {
            Program program = new Program();
            program.setProgramsOnDisc(readProgramNamesToArray(programLine));
            programArray.add(program);
        }
        read.close();

        return programArray;
    }

    private ArrayList<Program> readProgramNamesToArray(String line) {
        ArrayList<Program> arrayOfPrograms = new ArrayList<>();
        String lineOfPrograms = line.substring(line.indexOf(">") + 1).trim();
        String[] programNames = lineOfPrograms.split(",");
        for (String programName : programNames) {
            arrayOfPrograms.add(new Program(programName.trim()));
        }
        return arrayOfPrograms;
    }
}
