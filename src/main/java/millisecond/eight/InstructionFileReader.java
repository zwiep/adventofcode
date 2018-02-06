package millisecond.eight;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructionFileReader {

    public List<Instruction> readFileToArrayOfInstructions(String inputFileLocation) throws IOException {
        BufferedReader read = new BufferedReader(new java.io.FileReader(inputFileLocation));
        ArrayList<Instruction> instructions = new ArrayList<>();
        String line;

        while ((line = read.readLine()) != null) {
            Instruction instruction = new Instruction();
            String[] splitPrefix = StringUtils.split((StringUtils.splitByWholeSeparator(line, "if"))[0], " ");
            instruction.setRegisterName(splitPrefix[0]);
            instruction.setOperator(getOperator(splitPrefix[1]));
            instruction.setAmount(Integer.parseInt(splitPrefix[2]));
            instruction.setCondition(getConditionFromLine(line));

            instructions.add(instruction);
        }
        read.close();

        return instructions;
    }

    Condition getConditionFromLine(String line) {
        Condition condition = new Condition();
        String[] splitCondition = StringUtils.split((StringUtils.splitByWholeSeparator(line, "if"))[1], " ");
        condition.setPartOne(splitCondition[0].trim());
        condition.setPartTwo(Integer.parseInt(splitCondition[2].trim()));
        condition.setOperator(getOperator(splitCondition[1]));
        return condition;
    }

    private Operator getOperator(String s) {
        switch (s.trim()) {
            case ">":
                return Operator.GREATER_THAN;
            case "<":
                return Operator.LESS_THAN;
            case "==":
                return Operator.EQUALS;
            case "!=":
                return Operator.NOT_EQUALS;
            case "inc":
                return Operator.INCREASE;
            case "dec":
                return Operator.DECREASE;
            case "<=":
                return Operator.LESS_THAN_OR_EQUALS;
            case ">=":
                return Operator.GREATER_THAN_OR_EQUALS;
            default:
                throw new IllegalArgumentException(s + " is an unknown operator");
        }
    }
}
