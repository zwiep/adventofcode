package millisecond.eight;

import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.*;

public class InstructionFileReaderTest {

    InstructionFileReader instructionFileReader = new InstructionFileReader();

    @Test
    public void getConditionFromLine_extractsConditionCorrectly() {
        Condition actualCondition = instructionFileReader.getConditionFromLine("b inc 5 if a > 1");

        assertThat(actualCondition.getPartOne()).isEqualTo("a");
        assertThat(actualCondition.getPartTwo()).isEqualTo(1);
        assertThat(actualCondition.getOperator()).isEqualTo(Operator.GREATER_THAN);
    }
}