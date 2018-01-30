package millisecond.seven;

import org.fest.assertions.Assertions;
import org.junit.Test;
import sun.plugin.perf.PluginRollup;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProgramTest {

    FileReader fileReader = new FileReader();

    @Test
    public void calculateLoad_returnsCorrectLoad() throws IOException {
        ArrayList<Program> inputArray = createExampleInputProgram();
        int index = 0;
        for (Program program : inputArray) {
            System.out.println("index: " + index + " program: " + program.getName() + " - " + program.getWeight());
            index++;
            if (program.supportsOtherPrograms()) {
                for (Program subProgram : program.getProgramsOnDisc()) {
                    System.out.println(" " + subProgram.getName() +" - " + subProgram.getWeight());
                }
            }
        }
        int ugmlLoad = inputArray.get(9).getTotalLoad();
        int padxLoad = inputArray.get(8).getTotalLoad();
        int fwftLoad = inputArray.get(6).getTotalLoad();

        Assertions.assertThat(ugmlLoad).isEqualTo(251);
        Assertions.assertThat(padxLoad).isEqualTo(243);
        Assertions.assertThat(fwftLoad).isEqualTo(243);
    }

    @Test
    public void isBalanced_returnsTrue_whenProgramIsBalanced() {
        Program subA = new Program("name", 1, new ArrayList<>());
        Program subB = new Program("name", 1, new ArrayList<>());
        Program subC = new Program("name", 1, new ArrayList<>());
        Program root = new Program("root", 5, Arrays.asList(subA, subB, subC));

        Assertions.assertThat(root.isBalanced()).isTrue();

    }

    @Test
    public void isBalanced_returnsTrue_whenProgramHasNoChildPrograms() {
        Program root = new Program("root", 5, new ArrayList<>());

        Assertions.assertThat(root.isBalanced()).isTrue();
    }

    @Test
    public void isBalanced_returnsFalse_whenProgramIsUnbalanced() {
        Program subA = new Program("name", 1, new ArrayList<>());
        Program subB = new Program("name", 2, new ArrayList<>());
        Program subC = new Program("name", 1, new ArrayList<>());
        Program root = new Program("root", 5, Arrays.asList(subA, subB, subC));

        Assertions.assertThat(root.isBalanced()).isTrue();
    }

    public ArrayList<Program> createExampleInputProgram() throws IOException {
        return fileReader.readFiletoArrayOfPrograms("src/test/resources/millisecond/seven/test_tower_input");
    }

}