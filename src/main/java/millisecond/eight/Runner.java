package millisecond.eight;

import java.io.IOException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException {
        InstructionFileReader instructionFileReader = new InstructionFileReader();
        ValueFinder valueFinder = new ValueFinder();
        List<Instruction> instructions = instructionFileReader.readFileToArrayOfInstructions("src/main/resources/millisecond/eight/ms8_pt1_input");
        System.out.println("largest value after execution: " + valueFinder.findLargestValueAfterExecution(instructions));
        System.out.println("largest value at any time    : " + valueFinder.largestValueRecorded);

    }
}
