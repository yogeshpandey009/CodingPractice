package code;

public class ReverseNumber {

    public static void main(String[] args) {
        System.out.println(solution(123, 3));
    }

    private static int solution(int num1, int num2) {
        return reverse(reverse(num1) + reverse(num2));
    }

    private static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int last = num % 10;
            rev = rev * 10 + last;
            num = num / 10;
        }
        return rev;
    }
}
