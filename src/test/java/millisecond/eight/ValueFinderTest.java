package millisecond.eight;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static millisecond.eight.ConditionTestBuilder.aCondition;

public class ValueFinderTest {

    ValueFinder valueFinder = new ValueFinder();

    @Test
    public void findLargestValue_returnsLargestValueAfterInstructions() {
        List<Instruction> instructions = Arrays.asList(
            buildInstruction("b", Operator.INCREASE, 5, "a", Operator.GREATER_THAN, 1),
            buildInstruction("a", Operator.INCREASE, 1, "b", Operator.LESS_THAN, 5),
            buildInstruction("c", Operator.DECREASE, -10, "a", Operator.GREATER_THAN_OR_EQUALS, 1),
            buildInstruction("c", Operator.INCREASE, -20, "c", Operator.EQUALS, 10)
        );

        Assertions.assertThat(valueFinder.findLargestValueAfterExecution(instructions)).isEqualTo(1);
    }

    private Instruction buildInstruction(String register, Operator operator, int amount, String conditionPartOne, Operator conditionOperator, Integer conditionPartTwo) {
        return new InstructionTestBuilder()
                .withRegisterName(register)
                .withOperator(operator)
                .withAmount(amount)
                .withCondition(aCondition()
                        .withPartOne(conditionPartOne)
                        .withOperator(conditionOperator)
                        .withPartTwo(conditionPartTwo)
                        .build())
                .build();
    }
}