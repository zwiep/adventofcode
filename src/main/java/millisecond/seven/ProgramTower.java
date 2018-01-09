package millisecond.seven;

import java.util.ArrayList;
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

    public Program findUnbalancedProgram(ArrayList<Program> inputArrayOfPrograms) {
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


    public boolean checkProgramIsBalanced(Program inputProgram) {
        if (inputProgram.supportsOtherPrograms) {
            Set set = new HashSet<Integer>();
            ArrayList<Program> programsOnDisc = inputProgram.getProgramsOnDisc();
            for (Program program : programsOnDisc) {
                set.add(program.getWeight());
            }
            if (set.size() > 1) {
                return false;
            }
        }
        return true;
    }
}
