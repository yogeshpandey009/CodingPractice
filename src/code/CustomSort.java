package code;

import java.util.Arrays;

public class CustomSort {

    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 2, 0};
        char[] c = new char[]{'b', 'a', 'd', 'c'};

        for (int i = 0; i < a.length; i++) {
            while (a[i] != i) {
                int j = a[i];
                swap(a, i, j);
                swap(c, i, j);
            }
        }

        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(a));
    }

    public static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    public static void swap(char[] a, int x, int y) {
        char t = a[x];
        a[x] = a[y];
        a[y] = t;
    }
}
