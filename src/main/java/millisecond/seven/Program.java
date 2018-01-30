package millisecond.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program {

    private String name;
    private int weight;
    private List<Program> programsOnDisc = new ArrayList<>();
    private Program parentProgram;

    public Program() {
    }

    public Program(String name) {
        this.name = name;
    }

    public Program(String name, int weight, List<Program> programsOnDisc) {
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

    public List<Program> getProgramsOnDisc() {
        return programsOnDisc;
    }

    public void setProgramsOnDisc(ArrayList<Program> programsOnDisc) {
        this.programsOnDisc = programsOnDisc;
    }

    public int getTotalLoad() {
        int totalLoad = this.weight + calculateLoad();
        return totalLoad;
    }

    public Program getParentProgram() {
        return parentProgram;
    }

    public void setParentProgram(Program parentProgram) {
        this.parentProgram = parentProgram;
    }

    public boolean supportsOtherPrograms() {
        return programsOnDisc.size() > 0;
    }

    private int calculateLoad() {
        int total = 0;
        if (supportsOtherPrograms()) {
            for (Program program : programsOnDisc) {
                total += program.getTotalLoad();
            }
        }
        return total;
    }

    public boolean isBalanced() {
        Set set = new HashSet();
        for (Program program : programsOnDisc) {
            set.add(program.getTotalLoad());
        }
        return set.size() <= 1;
    }
}
