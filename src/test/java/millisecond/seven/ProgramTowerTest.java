package millisecond.seven;

import org.fest.assertions.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProgramTowerTest {

    ProgramTower programTower = new ProgramTower();
    FileReader fileReader = new FileReader();

    @Test
    public void findBottomProgram_returnsProgramWithCorrectName() throws IOException {
        ArrayList<Program> testTowerArray = fileReader.readFiletoArrayOfPrograms("src/test/resources/millisecond/seven/test_tower_input");
        Program expectedBottomProgram = new Program("tknk");

        Program actualBottomProgram = programTower.findBottomProgram(testTowerArray);

        Assertions.assertThat(actualBottomProgram.getName()).isEqualTo(expectedBottomProgram.getName());
    }

    @Ignore
    @Test
    public void findUnbalancedProgram_returnsProgramWhichIsUnbalanced() throws IOException {
        ArrayList<Program> testTowerArray = fileReader.readFiletoArrayOfPrograms("src/test/resources/millisecond/seven/test_tower_input");
        Program expectedUnbalancedProgram = new Program("tknk");

        Program actualUnbalancedProgram = programTower.findUnbalancedProgram(testTowerArray);

        Assertions.assertThat(actualUnbalancedProgram.getName()).isEqualTo(expectedUnbalancedProgram.getName());
    }

    @Test
    public void checkIfTowerIsBalanced_returnsCorrectBooleanValue_ifTowerIsBalanced() {
        ArrayList<Program> inputProgramArray = new ArrayList<>(Arrays.asList(
                new Program("tower1", 61, null),
                new Program("tower2", 61, null),
                new Program("tower3", 61, null)
        ));
        Program inputProgram = new Program("test", 45, inputProgramArray);

        Assertions.assertThat(programTower.checkProgramIsBalanced(inputProgram)).isTrue();
    }

    @Test
    public void checkIfTowerIsBalanced_returnsCorrectBooleanValue_ifTowerIsUnbalanced() {
        ArrayList<Program> inputProgramArray = new ArrayList<>(Arrays.asList(
                new Program("tower1", 61, null),
                new Program("tower2", 34, null),
                new Program("tower3", 61, null)
        ));
        Program inputProgram = new Program("test", 45, inputProgramArray);
        inputProgram.setSupportsOtherPrograms(true);

        Assertions.assertThat(programTower.checkProgramIsBalanced(inputProgram)).isFalse();
    }
}