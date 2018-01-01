package millisecond.four;

import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    PasswordValidator passwordValidator = new PasswordValidator();

    /*
    aa bb cc dd ee is valid.
    aa bb cc dd aa is not valid - the word aa appears more than once.
    aa bb cc dd aaa is valid - aa and aaa count as different words.
     */

    @Test
    public void aValidPassphrase_returnsTrue() {
        Boolean checkPassphrase = passwordValidator.isValidPassword("aa bb cc dd ee");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    @Test
    public void anInvalidPassphrase_returnsFalse() {
        Boolean checkPassphrase = passwordValidator.isValidPassword("aa bb cc dd aa");
        Assertions.assertThat(checkPassphrase).isFalse();
    }

    @Test
    public void anotherValidPassphrase_returnsTrue() {
        Boolean checkPassphrase = passwordValidator.isValidPassword("aa bb cc dd aaa");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    /*
    abcde fghij is a valid passphrase.
    abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
    a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
    iiii oiii ooii oooi oooo is valid.
    oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
     */
}