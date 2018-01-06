package utils;

import millisecond.seven.Program;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.fest.assertions.Assertions.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.*;

public class FileReaderTest {

    FileReader fileReader = new FileReader();
    String inputTestFileLocation = "src/test/resources/millisecond/seven/test_tower_input";
    String inputLine = "rqtlp (13) -> tmoib, pidha, yaqiuq, zprfu, ssjau, duhaz, qzaecfk";
    String shortInput = "rqtlp (13)";

    @Test
    public void readLineToProgram_takesNameFromLine_returnsProgramWithCorrectName() {
        String expectedName = "rqtlp";

        Program actualProgram = fileReader.readLineToProgram(inputLine);

        assertThat(actualProgram.getName()).isEqualTo(expectedName);
    }

    @Test
    public void readLineToProgram_takesWeightFromLine_returnsProgramWithCorrectWeight() {
        int expectedWeight = 13;

        Program actualProgram = fileReader.readLineToProgram(inputLine);

        assertThat(actualProgram.getWeight()).isEqualTo(expectedWeight);
    }

    @Test
    public void readLineToProgram_takesProgramsFromLine_returnsProgramWithArrayOfPrograms() {
        ArrayList<Program> expectedArrayOfPrograms = createExpectedArrayOfPrograms();

        Program actualProgram = fileReader.readLineToProgram(inputLine);

        assertLenientEquals(expectedArrayOfPrograms, actualProgram.getProgramsOnDisc());
    }

    @Test
    public void readLineToProgram_takesNameFromLine_returnsProgramWithCorrectName_whenOnlyNameAndWeightAreAvailable() {
        String expectedName = "rqtlp";

        Program actualProgram = fileReader.readLineToProgram(shortInput);

        assertThat(actualProgram.getName()).isEqualTo(expectedName);
    }

    @Test
    public void readLineToProgram_takesWeightFromLine_returnsProgramWithCorrectWeight_whenOnlyNameAndWeightAreAvailable() {
        int expectedWeight = 13;

        Program actualProgram = fileReader.readLineToProgram(shortInput);

        assertThat(actualProgram.getWeight()).isEqualTo(expectedWeight);
    }

    @Test
    public void readFileToProgramArray_returnsArrayOfCorrectSize() throws IOException {
        ArrayList<Program> actualArray = fileReader.readFiletoArrayOfPrograms(inputTestFileLocation);
        Assertions.assertThat(actualArray).hasSize(13);
    }

    private ArrayList<Program> createExpectedArrayOfPrograms() {
        return new ArrayList<>(
                Arrays.asList(
                        new Program("tmoib"),
                        new Program("pidha"),
                        new Program("yaqiuq"),
                        new Program("zprfu"),
                        new Program("ssjau"),
                        new Program("duhaz"),
                        new Program("qzaecfk")
                )
        );
    }
}