package millisecond.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgramTower {

    public Program findBottomProgram(ArrayList<Program> inputArrayOfPrograms) {

        ArrayList<String> allNames = createArrayOfAllNames(inputArrayOfPrograms);
        ArrayList<String> allReferencedNames = createArrayOfReferencedNames(inputArrayOfPrograms);

        allNames.removeAll(allReferencedNames);
        String bottomProgramName = allNames.get(0);

        for (Program program : inputArrayOfPrograms) {
            if (program.getName().equals(bottomProgramName)) {
                return program;
            }
        }
        return null;
    }

    private ArrayList<String> createArrayOfAllNames(ArrayList<Program> inputArrayOfPrograms) {
        ArrayList<String> allNames = new ArrayList<>();
        for (Program program : inputArrayOfPrograms) {
            allNames.add(program.getName());
        }
        return allNames;
    }

    private ArrayList<String> createArrayOfReferencedNames(ArrayList<Program> inputArrayOfPrograms) {
        ArrayList<String> names = new ArrayList<>();
        for (Program inputProgram : inputArrayOfPrograms) {
            if (inputProgram.getProgramsOnDisc() != null) {
                for (Program program : inputProgram.getProgramsOnDisc()) {
                    names.add(program.getName());
                }
            }
        }
        return names;
    }

    public int weightDifferenceForUnbalancedTower(ArrayList<Program> inputArrayOfPrograms) {
        List<Integer> weights = new ArrayList<>();
        int weightDifference = 0;
        for (Program program : inputArrayOfPrograms) {
            if (program.isBalanced()) {
                if (program.getParentProgram() != null) {
                    if (!(program.getParentProgram()).isBalanced()) {
                        for (Program subprogram : program.getParentProgram().getProgramsOnDisc()) {
                            weights.add(subprogram.getTotalLoad());
                        }
                        weightDifference = weights.stream().max(Integer::compare).get() - weights.stream().min(Integer::compare).get();
                    }
                }
            }
        }
        return weightDifference;
    }

    public Program findProgramToCorrect(ArrayList<Program> testTowerArray) {
        List<Program> faultyPrograms = new ArrayList<>();
        for (Program program : testTowerArray) {
            if (program.isBalanced()) {
                if (program.getParentProgram() != null) {
                    if (!(program.getParentProgram()).isBalanced()) {
                        faultyPrograms = program.getParentProgram().getProgramsOnDisc();
                        return singleOutProgram(faultyPrograms);
                    }
                }
            }
        }
        return null;
    }

    public Program singleOutProgram(List<Program> faultyPrograms) {
        for (Program program : faultyPrograms) {
            int count = 0;
            for (Program subProgram : faultyPrograms) {
                if(subProgram.getTotalLoad() == program.getTotalLoad()) {
                    count++;
                }
            }
            if (count == 1) {
                return program;
            }
        }
        return null;
    }

    public int calculateCorrectWeightOfProgram(Program inputProgram) {
        int commonWeight = 0;
        Program rootProgram = inputProgram.getParentProgram();
        for (Program program : rootProgram.getProgramsOnDisc()) {
            int count = 0;
            for (Program subProgram : rootProgram.getProgramsOnDisc()) {
                if (subProgram.getTotalLoad() == program.getTotalLoad()) {
                    count ++;
                }
            }
            if (count > 1) {
                commonWeight = program.getTotalLoad();
            }
        }
        int difference = commonWeight - inputProgram.getTotalLoad();
        return inputProgram.getWeight() + difference;
    }

    public int findProgramAndCorrectWeight(ArrayList<Program> testTowerArray) {
        Program faultyProgram = findProgramToCorrect(testTowerArray);
        return calculateCorrectWeightOfProgram(faultyProgram);
    }
}
