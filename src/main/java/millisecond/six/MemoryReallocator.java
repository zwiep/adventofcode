package millisecond.six;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MemoryReallocator {


    public ArrayList<Integer> reallocate(ArrayList<Integer> memory) {
        int bankSize = memory.size() - 1;
        int valueToRedistribute = Collections.max(memory);
        int maxIndex = findIndexOfFirstMaxValue(memory);
        int currentIndex = maxIndex;

        memory.set(currentIndex, 0);
        while (valueToRedistribute > 0) {
            if (currentIndex < bankSize) {
                currentIndex++;
            } else {
                currentIndex = 0;
            }
            valueToRedistribute--;
            memory.set(currentIndex, memory.get(currentIndex) + 1);
        }
        return memory;
    }

    public int countCycles(ArrayList<Integer> memory) {
        int cycles = 0;
        boolean alreadyHadThisSet = false;
        ArrayList<ArrayList<Integer>> memoryHistory = new ArrayList<>();

        while (!alreadyHadThisSet) {
            memory = reallocate(memory);
            memoryHistory.add(memory);
            Set<ArrayList> historySet = new HashSet<>(memoryHistory);
            if (memoryHistory.size() > historySet.size()) {
                alreadyHadThisSet = true;
            }
            cycles++;
        }

        return cycles;
    }

    private int findIndexOfFirstMaxValue(ArrayList<Integer> startMemory) {
        int index = 0;
        int maxIndex = 0;
        boolean found = false;

        for (int currentValue : startMemory) {
            if ((currentValue == Collections.max(startMemory)) && !found) {
                maxIndex = index;
                found = true;
            }
            index++;
        }
        return maxIndex;
    }
}
