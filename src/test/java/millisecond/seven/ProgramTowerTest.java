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


    private Program createBalancedNestedTower() {
        ArrayList<Program> inputProgramArray1 = new ArrayList<>(Arrays.asList(
                new Program("1", 4, null),
                new Program("2", 4, null),
                new Program("3", 4, null)
        ));
        ArrayList<Program> inputProgramArray2 = new ArrayList<>(Arrays.asList(
                new Program("4", 6, null),
                new Program("5", 6, null)
        ));
        ArrayList<Program> inputProgramArray3 = new ArrayList<>(Arrays.asList(
                new Program("7", 3, null),
                new Program("8", 3, null),
                new Program("9", 3, null),
                new Program("10", 3, null)
        ));
        Program program11 = new Program("layer11", 2, inputProgramArray1);
        Program program12 = new Program("layer12", 2, inputProgramArray2);
        Program program13 = new Program("layer13", 2, inputProgramArray3);
        program11.setSupportsOtherPrograms(true);
        program12.setSupportsOtherPrograms(true);
        program13.setSupportsOtherPrograms(true);

        ArrayList<Program> inputProgramArray = new ArrayList<>(Arrays.asList(
                program11, program12, program13
        ));
        Program inputProgram = new Program("test", 1, inputProgramArray);
        inputProgram.setSupportsOtherPrograms(true);
        return inputProgram;
    }

    private Program createUnBalancedNestedTower() {
        ArrayList<Program> inputProgramArray1 = new ArrayList<>(Arrays.asList(
                new Program("1", 4, null),
                new Program("2", 4, null),
                new Program("3", 4, null)
        ));
        ArrayList<Program> inputProgramArray2 = new ArrayList<>(Arrays.asList(
                new Program("4", 6, null),
                new Program("5", 6, null)
        ));
        ArrayList<Program> inputProgramArray3 = new ArrayList<>(Arrays.asList(
                new Program("7", 3, null),
                new Program("8", 3, null),
                new Program("9", 3, null),
                new Program("10", 3, null)
        ));
        ArrayList<Program> inputProgramArray = new ArrayList<>(Arrays.asList(
                new Program("layer11", 2, inputProgramArray1),
                new Program("layer12", 3, inputProgramArray2),
                new Program("layer13", 2, inputProgramArray3)
        ));
        Program inputProgram = new Program("test", 1, inputProgramArray);
        inputProgram.setSupportsOtherPrograms(true);
        return inputProgram;
    }
}