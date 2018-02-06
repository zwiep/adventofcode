package millisecond.eight;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ValueFinder {

    private HashMap<String, Integer> registers = new HashMap<>();

    public int findLargestValue(List<Instruction> instructions) {
        executeInstructions(instructions);
        return Collections.max(registers.values());
    }

    private void executeInstructions(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            if (isTrue(instruction.getCondition())) {
                int newValue = 0;
                switch (instruction.getOperator()) {
                    case INCREASE:
                        newValue = getAmountOfRegister(instruction.getRegisterName()) + instruction.getAmount();
                        registers.put(instruction.getRegisterName(), newValue);
                        break;
                    case DECREASE:
                        newValue = getAmountOfRegister(instruction.getRegisterName()) - instruction.getAmount();
                        registers.put(instruction.getRegisterName(), newValue);
                        break;
                    default:
                        throw new IllegalArgumentException("Undefined operator: " + instruction.getOperator());
                }
            }
        }
    }

    private Integer getAmountOfRegister(String registerName) {
        if (!registers.containsKey(registerName)) {
            registers.put(registerName, 0);
        }
        return registers.get(registerName);
    }

    private boolean isTrue(Condition condition) {
        switch (condition.getOperator()) {
            case EQUALS:
                return getAmountOfRegister(condition.getPartOne()).equals(condition.getPartTwo());
            case NOT_EQUALS:
                return !getAmountOfRegister(condition.getPartOne()).equals(condition.getPartTwo());
            case GREATER_THAN:
                return getAmountOfRegister(condition.getPartOne()) > (condition.getPartTwo());
            case LESS_THAN:
                return getAmountOfRegister(condition.getPartOne()) < (condition.getPartTwo());
            case LESS_THAN_OR_EQUALS:
                return getAmountOfRegister(condition.getPartOne()) <= (condition.getPartTwo());
            case GREATER_THAN_OR_EQUALS:
                return getAmountOfRegister(condition.getPartOne()) >= (condition.getPartTwo());
            default:
                throw new IllegalArgumentException("Undefined operator: " + condition.getOperator());
        }

    }
}
