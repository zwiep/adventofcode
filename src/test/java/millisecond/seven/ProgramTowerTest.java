package millisecond.seven;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;

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
}