package code;

import java.util.Arrays;

public class HIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 1; i <= citations.length; i++) {
            if (citations[citations.length - i] == i) {
                return i;
            } else if (citations[citations.length - i] < i) {
                return i - 1;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        // int[] citations = new int[] {3, 1, 2};
        // int[] citations = new int[] {0, 0, 4, 4};
        // int[] citations = new int[] {1, 2};
        int[] citations = new int[]{0};
        // int[] citations = new int[] {100,200};
        System.out.println(hIndex(citations));
    }

}
