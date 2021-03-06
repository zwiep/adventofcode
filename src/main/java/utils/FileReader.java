package utils;

import millisecond.seven.Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    private ArrayList<Program> programArray = new ArrayList<>();

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

    public ArrayList<Program> readFiletoArrayOfPrograms(String fileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(fileLocation));
        String programLine;

        while ((programLine = read.readLine()) != null) {
            readLineToProgramArray(programLine);
        }
        read.close();
        return programArray;
    }


    public void readLineToProgramArray(String line) {
        String name = getName(line);
        int weight = getWeight(line);
        ArrayList<Program> programsOnDisc = readProgramNamesToArray(line);

        boolean exists = false;
        for (Program program : programArray) {
            if ((program.getName()).equals(name)) {
                exists = true;
                program.setWeight(weight);
                program.setProgramsOnDisc(programsOnDisc);
                for (Program programOnDisc : programsOnDisc) {
                    programOnDisc.setParentProgram(program);
                }
            }
        }
        if (!exists) {
            Program newProgram = new Program(name, weight, programsOnDisc);
            if (programsOnDisc != null && programsOnDisc.size() > 0) {
                for (Program programOnDisc : programsOnDisc) {
                    programOnDisc.setParentProgram(newProgram);
                }
            }
            programArray.add(newProgram);
        }
    }

    private Integer getWeight(String line) {
        return Integer.valueOf(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
    }

    private String getName(String line) {
        return line.substring(0, line.indexOf("(")).trim();
    }

    private ArrayList<Program> readProgramNamesToArray(String line) {
        ArrayList<Program> arrayOfPrograms = new ArrayList<>();
        if (line.contains(">")) {
            String lineOfPrograms = line.substring(line.indexOf(">") + 1).trim();
            String[] programNames = lineOfPrograms.split(", ");
            for (String programName : programNames) {
                boolean exists = false;
                for (Program program : programArray) {
                    if ((program.getName()).equals(programName)) {
                        arrayOfPrograms.add(program);
                        exists = true;
                    }
                }
                if (!exists) {
                    Program newProgram = new Program(programName.trim());
                    arrayOfPrograms.add(newProgram);
                    programArray.add(newProgram);

                }
            }
            return arrayOfPrograms;
        } else {
            return new ArrayList<>();
        }
    }
}
