package code;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0 && carry; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                carry = true;
            } else {
                digits[i]++;
                carry = false;
            }
        }
        if (carry) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}