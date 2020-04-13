package code;

public class ReverseFib {

    public static void main(String[] args) {

        int a = 160;
        int b = 100;

        System.out.print(a);
        while (b >= 0 && a >= b) {
            System.out.print("," + b);
            int temp = b;
            b = a - b;
            a = temp;
        }

    }
}
