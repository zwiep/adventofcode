package millisecond.seven;

import java.util.ArrayList;

public class ProgramTower {

    private ArrayList<Program> programs = new ArrayList<>();

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
                for (Program program : inputProgram.getProgramsOnDisc() ) {
                    names.add(program.getName());
                }
            }
        }
        return names;
    }
}
