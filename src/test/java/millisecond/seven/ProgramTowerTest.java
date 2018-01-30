package millisecond.seven;

import org.fest.assertions.Assertions;
import org.junit.Test;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void fixWeight_returnsExpectedWeightNeededToBalanceTower() throws IOException {
        ArrayList<Program> testTowerArray = fileReader.readFiletoArrayOfPrograms("src/test/resources/millisecond/seven/test_tower_input");
        int expectedWeightDifference = 8;

        int actualWeight = programTower.weightDifferenceForUnbalancedTower(testTowerArray);

        Assertions.assertThat(actualWeight).isEqualTo(expectedWeightDifference);
    }

    @Test
    public void findProgramToCorrect_returnsProgramThatNeedsWeightCorrection() throws IOException {
        ArrayList<Program> testTowerArray = fileReader.readFiletoArrayOfPrograms("src/test/resources/millisecond/seven/test_tower_input");
        Program expectedProgram = testTowerArray.get(9);

        Program actualProgram = programTower.findProgramToCorrect(testTowerArray);

        Assertions.assertThat(actualProgram).isEqualTo(expectedProgram);
    }

    @Test
    public void singleOutProgram_returnsProgramWithDifferentWeight() {
        Program subA = new Program("name", 1, new ArrayList<>());
        Program subB = new Program("name", 2, new ArrayList<>());
        Program subC = new Program("name", 1, new ArrayList<>());
        List<Program> list = Arrays.asList(subA, subB, subC);

        Program actualProgramToCorrect = programTower.singleOutProgram(list);

        Assertions.assertThat(actualProgramToCorrect).isEqualTo(subB);
    }

    @Test
    public void calculateCorrectWeight_returnsCorrectWeightOfFaultyProgram() throws IOException {
        ArrayList<Program> testTowerArray = fileReader.readFiletoArrayOfPrograms("src/test/resources/millisecond/seven/test_tower_input");
        int expectedWeight = 60;

        int actualWeight = programTower.calculateCorrectWeightOfProgram(testTowerArray.get(9));

        Assertions.assertThat(actualWeight).isEqualTo(expectedWeight);
    }
}