package millisecond.seven;

import java.util.ArrayList;

public class Program {

    private String name;
    private int weight;
    private int totalLoad;
    private ArrayList<Program> programsOnDisc = new ArrayList<>();
    private Program parentProgram;
    boolean supportsOtherPrograms;

    public Program() {
    }

    public Program(String name) {
        this.name = name;
    }

    public Program(String name, int weight, ArrayList<Program> programsOnDisc) {
        this.name = name;
        this.weight = weight;
        this.programsOnDisc = programsOnDisc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Program> getProgramsOnDisc() {
        return programsOnDisc;
    }

    public void setProgramsOnDisc(ArrayList<Program> programsOnDisc) {
        this.programsOnDisc = programsOnDisc;
    }

    public int getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(int totalLoad) {
        this.totalLoad = totalLoad;
    }

    public Program getParentProgram() {
        return parentProgram;
    }

    public void setParentProgram(Program parentProgram) {
        this.parentProgram = parentProgram;
    }

    public boolean isSupportsOtherPrograms() {
        return supportsOtherPrograms;
    }

    public void setSupportsOtherPrograms(boolean supportsOtherPrograms) {
        this.supportsOtherPrograms = supportsOtherPrograms;
    }
}
