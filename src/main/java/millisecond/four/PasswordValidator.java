package millisecond.four;

import utils.FileReader;

import java.io.IOException;
import java.util.*;

public class PasswordValidator {

    private FileReader fileReader = new FileReader();

    public int checkAmountOfValidPassphrases(String passPhraseInputFile) throws IOException {
        ArrayList<String> arrayOfPassphrases = fileReader.readStringFile(passPhraseInputFile);
        int amountValid = 0;
        for (String passPhrase : arrayOfPassphrases) {
            if (isValidPassword(passPhrase)) {
                amountValid++;
            }
        }
        return amountValid;
    }

    public boolean isValidPassword(String passPhrase) {
        boolean isValid;
        ArrayList<String> passPhraseArray = readStringToArrayOfSeparateWords(passPhrase);

        if (containsDoubles(passPhraseArray) || containsAnagrams(passPhraseArray)) {
            isValid = false;
        }
        else {
            isValid = true;
        }
        return isValid;
    }

    private boolean containsDoubles(ArrayList<String> passPhraseArray) {
        Set<String> uniqueWords = new HashSet<String>(passPhraseArray);

        if (uniqueWords.size() < passPhraseArray.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean containsAnagrams(ArrayList<String> passPhraseArray) {
        boolean containsAnagram = false;
        int i = 0;
        for (String sourceWord: passPhraseArray) {
            int j = 0;
            ArrayList<String> sourceWordArrayOfLetters = readWordToArrayOfSeparateLetters(sourceWord);
            Collections.sort(sourceWordArrayOfLetters);
            for (String compareWord: passPhraseArray) {
                ArrayList<String> compareWordArrayOfLetters = readWordToArrayOfSeparateLetters(compareWord);
                Collections.sort(compareWordArrayOfLetters);
                if (compareWordArrayOfLetters.equals(sourceWordArrayOfLetters) && (i != j)) {
                    containsAnagram = true;
                }
                j++;
            }
            i++;
        }
        return containsAnagram;
    }


    private ArrayList<String> readStringToArrayOfSeparateWords(String inputString) {
        String passPhraseSplit[] = inputString.split(" ");
        return new ArrayList<>(Arrays.asList(passPhraseSplit));
    }

    private ArrayList<String> readWordToArrayOfSeparateLetters(String word) {
        String wordSplit[] = word.split("");
        return new ArrayList<>(Arrays.asList(wordSplit));
    }
}
