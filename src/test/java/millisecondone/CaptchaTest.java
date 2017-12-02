package millisecondone;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class CaptchaTest {

    /*
    1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
    1111 produces 4 because each digit (all 1) matches the next.
    1234 produces 0 because no digit matches the next.
    91212129 produces 9 because the only digit that matches the next one is the last digit, 9.
    */

    @Test
    public void when_input1122_output3() {
        Captcha captcha = new Captcha();
        String input = "1122";
        int output = captcha.validateCaptchaOne(input);
        Assertions.assertThat(output).isEqualTo(3);
    }

    @Test
    public void when_input1111_output4() {
        Captcha captcha = new Captcha();
        String input = "1111";
        int output = captcha.validateCaptchaOne(input);
        Assertions.assertThat(output).isEqualTo(4);
    }

    @Test
    public void when_input1234_output0() {
        Captcha captcha = new Captcha();
        String input = "1234";
        int output = captcha.validateCaptchaOne(input);
        Assertions.assertThat(output).isEqualTo(0);

    }

    @Test
    public void when_input91212129_output9() {
        Captcha captcha = new Captcha();
        String input = "91212129";
        int output = captcha.validateCaptchaOne(input);
        Assertions.assertThat(output).isEqualTo(9);
    }


    /*
    1212 produces 6: the list contains 4 items, and all four digits match the digit 2 items ahead.
    1221 produces 0, because every comparison is between a 1 and a 2.
    123425 produces 4, because both 2s match each other, but no other digit has a match.
    123123 produces 12.
    12131415 produces 4.
     */

    @Test
    public void when_input1212_output6() {
        Captcha captcha = new Captcha();
        String input = "1212";
        int output = captcha.validateCaptchaTwo(input);
        Assertions.assertThat(output).isEqualTo(6);
    }

    @Test
    public void when_input1221_output0() {
        Captcha captcha = new Captcha();
        String input = "1221";
        int output = captcha.validateCaptchaTwo(input);
        Assertions.assertThat(output).isEqualTo(0);
    }

    @Test
    public void when_input123425_output4() {
        Captcha captcha = new Captcha();
        String input = "123425";
        int output = captcha.validateCaptchaTwo(input);
        Assertions.assertThat(output).isEqualTo(4);
    }

    @Test
    public void when_input123123_output12() {
        Captcha captcha = new Captcha();
        String input = "123123";
        int output = captcha.validateCaptchaTwo(input);
        Assertions.assertThat(output).isEqualTo(12);
    }

    @Test
    public void when_input12131415_output4() {
        Captcha captcha = new Captcha();
        String input = "12131415";
        int output = captcha.validateCaptchaTwo(input);
        Assertions.assertThat(output).isEqualTo(4);
    }
}