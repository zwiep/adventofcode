package millisecond.seven;

import java.util.ArrayList;

public class ProgramTestBuilder {

    private String name;
    private int weight;
    private ArrayList<Program> programsOnDisc = new ArrayList<>();
    private Program parentProgram;
    boolean supportsOtherPrograms;

    public static ProgramTestBuilder aProgram() {
        return new ProgramTestBuilder();
    }

    private Program build() {
        Program program = new Program();
        program.setName(name);
        program.setWeight(weight);
        program.setProgramsOnDisc(programsOnDisc);
        program.setParentProgram(parentProgram);

        return program;
    }

    public ProgramTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProgramTestBuilder withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public ProgramTestBuilder withProgramsOnDisc(ArrayList<Program> programsOnDisc) {
        this.programsOnDisc = programsOnDisc;
        return this;
    }

    public ProgramTestBuilder withParentProgram(Program parentProgram) {
        this.parentProgram = parentProgram;
        return this;
    }

    public ProgramTestBuilder withSupportsOtherPrograms(boolean supportsOtherPrograms) {
        this.supportsOtherPrograms = supportsOtherPrograms;
        return this;
    }
}
