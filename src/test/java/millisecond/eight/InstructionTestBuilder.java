package millisecond.eight;

import static org.junit.Assert.*;

public class InstructionTestBuilder {

    private String registerName;
    private Operator operator;
    private int amount;
    private Condition condition;

    public Instruction build() {
        Instruction instruction = new Instruction();
        instruction.setRegisterName(registerName);
        instruction.setOperator(operator);
        instruction.setAmount(amount);
        instruction.setCondition(condition);

        return instruction;
    }

    public InstructionTestBuilder withRegisterName(String registerName) {
        this.registerName = registerName;
        return this;
    }

    public InstructionTestBuilder withOperator(Operator operator) {
        this.operator = operator;
        return this;
    }

    public InstructionTestBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public InstructionTestBuilder withCondition(Condition condition) {
        this.condition = condition;
        return this;
    }
}