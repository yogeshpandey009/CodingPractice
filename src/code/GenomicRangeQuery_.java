package code;

public class GenomicRangeQuery_ {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int len = S.length();
        int[] a = new int[len];
        int[] output = new int[P.length];
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == 'A')
                a[i] = 1;
            else if (c == 'C')
                a[i] = 2;
            else if (c == 'G')
                a[i] = 3;
            else if (c == 'T')
                a[i] = 4;
        }
        for (int i = 0; i < P.length; i++) {
            int min = a[P[i]];
            for (int j = P[i] + 1; j <= Q[i]; j++) {
                if (a[j] < min) {
                    min = a[j];
                }
            }
            output[i] = min;
        }
        return output;
    }
}
