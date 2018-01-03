package millisecond.six;

import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MemoryReallocatorTest {

    MemoryReallocator memoryReallocator = new MemoryReallocator();

    @Test
    public void reallocate_takesHighestValue_andRedistributes() {
        ArrayList<Integer> startMemory = new ArrayList<>(Arrays.asList(0, 2, 7, 0));
        ArrayList<Integer> expectedResultMemory = new ArrayList<>(Arrays.asList(2, 4, 1, 2));

        ArrayList<Integer> actualResultMemory = memoryReallocator.reallocate(startMemory);

        Assertions.assertThat(actualResultMemory).isEqualTo(expectedResultMemory);
    }

    @Test
    public void reallocate_takesHighestValue_andRedistributes_again() {
        ArrayList<Integer> startMemory = new ArrayList<>(Arrays.asList(2, 4, 1, 2));
        ArrayList<Integer> expectedResultMemory = new ArrayList<>(Arrays.asList(3, 1, 2, 3));

        ArrayList<Integer> actualResultMemory = memoryReallocator.reallocate(startMemory);

        Assertions.assertThat(actualResultMemory).isEqualTo(expectedResultMemory);
    }

    @Test
    public void reallocate_takesHighestValue_andRedistributes_yetAgain() {
        ArrayList<Integer> startMemory = new ArrayList<>(Arrays.asList(3, 1, 2, 3));
        ArrayList<Integer> expectedResultMemory = new ArrayList<>(Arrays.asList(0, 2, 3, 4));

        ArrayList<Integer> actualResultMemory = memoryReallocator.reallocate(startMemory);

        Assertions.assertThat(actualResultMemory).isEqualTo(expectedResultMemory);
    }

    @Test
    public void reallocate_takesHighestValue_andRedistributes_andAgain() {
        ArrayList<Integer> startMemory = new ArrayList<>(Arrays.asList(0, 2, 3, 4));
        ArrayList<Integer> expectedResultMemory = new ArrayList<>(Arrays.asList(1, 3, 4, 1));

        ArrayList<Integer> actualResultMemory = memoryReallocator.reallocate(startMemory);

        Assertions.assertThat(actualResultMemory).isEqualTo(expectedResultMemory);
    }

    @Test
    public void reallocate_takesHighestValue_andRedistributes_andYetAgain() {
        ArrayList<Integer> startMemory = new ArrayList<>(Arrays.asList(1, 3, 4, 1));
        ArrayList<Integer> expectedResultMemory = new ArrayList<>(Arrays.asList(2, 4, 1, 2));

        ArrayList<Integer> actualResultMemory = memoryReallocator.reallocate(startMemory);

        Assertions.assertThat(actualResultMemory).isEqualTo(expectedResultMemory);
    }

    @Test
    public void counCycles_countsCyclesUntilAllocationComplete() {
        ArrayList<Integer> startMemory = new ArrayList<>(Arrays.asList(0, 2, 7, 0));
        int expectedCycles = 5;

        int actualCycles = memoryReallocator.countCycles(startMemory);

        Assertions.assertThat(actualCycles).isEqualTo(expectedCycles);
    }
}