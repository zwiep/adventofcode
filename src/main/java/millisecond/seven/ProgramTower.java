package millisecond.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
                inputProgram.setSupportsOtherPrograms(true);
                for (Program program : inputProgram.getProgramsOnDisc() ) {
                    names.add(program.getName());
                }
            }
            else {
                inputProgram.setTotalLoad(0);
                inputProgram.setSupportsOtherPrograms(false);
            }
        }
        return names;
    }


    /*private ArrayList<Program> createArrayOfUnbalancedPrograms(ArrayList<Program> inputArrayOfPrograms) {
        ArrayList<Program> allPrograms = new ArrayList<>();
        ArrayList<Program> unbalancedPrograms = new ArrayList<>();
        for (Program program : inputArrayOfPrograms) {
            allPrograms.add(program);
        }
        for (Program program : allPrograms) {
            if (checkProgramIsBalanced(program)) {
                unbalancedPrograms.add(program);
            }
        }
        return unbalancedPrograms;
    }

    public boolean checkProgramIsBalanced(Program inputProgram) {
        if (inputProgram.supportsOtherPrograms) {
            Set set = new HashSet<Integer>();
            ArrayList<Program> programsOnDisc = inputProgram.getProgramsOnDisc();
            for (Program program : programsOnDisc) {
                set.add(calculateTotalLoad(program));
            }
            if (set.size() > 1) {
                return false;
            }
        }
        return true;
    }

    public int calculateTotalLoad(Program inputProgram) {
        int load = inputProgram.getWeight();
        if (inputProgram.supportsOtherPrograms) {
            for (Program otherProgram: inputProgram.getProgramsOnDisc()) {
                load = load + calculateTotalLoad(otherProgram);
            }
        }
        return load;
    }

    public int calculateWeightDifference(ArrayList<Program> inputArrayOfPrograms) {
        ArrayList<Program> unbalancedPrograms = createArrayOfUnbalancedPrograms(inputArrayOfPrograms);
        int result = 0;
        int max = calculateTotalLoad(unbalancedPrograms.get(0));
        int min = calculateTotalLoad(unbalancedPrograms.get(0));;

        for (Program program : unbalancedPrograms) {
            int load = calculateTotalLoad(program);
            if ( load < min) {
                min = load;
            }
            if (load > max) {
                max = load;
            }
        }

        result = max - min;
        return result;
    }*/
}
