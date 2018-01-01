package millisecond.four;

import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public Boolean isValidPassword(String passPhrase) {
        ArrayList<String> passPhraseArray = readStringToArrayOfSeperateWords(passPhrase);
        Set<String> uniqueValues = new HashSet<String>(passPhraseArray);
        if (uniqueValues.size() < passPhraseArray.size()) {
            return false;
        } else {
            return true;
        }
    }

    private ArrayList<String> readStringToArrayOfSeperateWords(String inputString) {
        String passPhraseSplit[] = inputString.split(" ");
        return new ArrayList<String>(Arrays.asList(passPhraseSplit));
    }
}
