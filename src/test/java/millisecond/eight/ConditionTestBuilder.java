package millisecond.eight;

public class ConditionTestBuilder {

    private Condition condition = new Condition();

    private ConditionTestBuilder(){}

    public static ConditionTestBuilder aCondition(){
        return new ConditionTestBuilder();
    }

    public Condition build() {
        return condition;
    }

    public ConditionTestBuilder withPartOne(String partOne) {
        this.condition.setPartOne(partOne);
        return this;
    }


    public ConditionTestBuilder withOperator(Operator operator) {
        this.condition.setOperator(operator);
        return this;
    }


    public ConditionTestBuilder withPartTwo(Integer partTwo) {
        this.condition.setPartTwo(partTwo);
        return this;
    }

}