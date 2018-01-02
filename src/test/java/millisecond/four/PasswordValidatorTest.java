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
        boolean checkPassphrase = passwordValidator.isValidPassword("aa bb cc dd ee");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    @Test
    public void anInvalidPassphrase_returnsFalse() {
        boolean checkPassphrase = passwordValidator.isValidPassword("aa bb cc dd aa");
        Assertions.assertThat(checkPassphrase).isFalse();
    }

    @Test
    public void anotherValidPassphrase_returnsTrue() {
        boolean checkPassphrase = passwordValidator.isValidPassword("aa bb cc dd aaa");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    /*
    abcde fghij is a valid passphrase.
    abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
    a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
    iiii oiii ooii oooi oooo is valid.
    oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
     */

    @Test
    public void anAnagramValidPassphrase_returnsTrue() {
        boolean checkPassphrase = passwordValidator.isValidPassword("abcde fghij");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    @Test
    public void anAnagramInvalidPassphrase_returnsFalse() {
        boolean checkPassphrase = passwordValidator.isValidPassword("abcde xyz ecdab");
        Assertions.assertThat(checkPassphrase).isFalse();
    }

    @Test
    public void anotherAnagramValidPassphrase_returnsTrue() {
        boolean checkPassphrase = passwordValidator.isValidPassword("a ab abc abd abf abj");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    @Test
    public void yetAnotherAnagramValidPassphrase_returnsTrue() {
        boolean checkPassphrase = passwordValidator.isValidPassword("iiii oiii ooii oooi oooo");
        Assertions.assertThat(checkPassphrase).isTrue();
    }

    @Test
    public void anotherAnagramInvalidPassphrase_returnsFalse() {
        Boolean checkPassphrase = passwordValidator.isValidPassword("oiii ioii iioi iiio");
        Assertions.assertThat(checkPassphrase).isFalse();
    }
}