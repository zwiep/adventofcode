package millisecond.one;

public class Captcha {

    public int validateCaptchaOne(String input) {
        int sum = 0;
        int y;
        int x;

        for (int i = 0; i < input.length(); i++) {
            x = Character.getNumericValue(input.charAt(i));
            if (i == input.length() - 1) {
                y = Character.getNumericValue(input.charAt(0));
            } else {
                y = Character.getNumericValue(input.charAt(i+1));
            }
            if (x == y) {
                sum = sum + x;
            }
        }

        return sum;
    }

    public int validateCaptchaTwo(String input) {
        int sum = 0;
        int halfwayIndex = (input.length()) / 2;
        int y;
        int x;

        for (int i = 0; i < input.length(); i++) {
            int yIndex = i + halfwayIndex;
            x = Character.getNumericValue(input.charAt(i));
            if (yIndex > input.length()-1) {
                yIndex = yIndex - input.length();
                y = Character.getNumericValue(input.charAt(yIndex));
            } else {
                y = Character.getNumericValue(input.charAt(yIndex));
            }
            if (x == y) {
                sum = sum + x;
            }
        }

        return sum;
    }
}
