package millisecond.seven;

import java.util.ArrayList;

public class Program {

    private String name;
    private int weight;
    private ArrayList<Program> programsOnDisc = new ArrayList<>();

    public Program() {
    }

    public Program(String name) {
        this.name = name;
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
}
