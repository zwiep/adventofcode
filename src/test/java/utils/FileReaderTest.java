package utils;

import millisecond.seven.Program;
import org.fest.assertions.Assertions;
import org.junit.Test;

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