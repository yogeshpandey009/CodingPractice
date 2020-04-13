package code;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int arr[], int start, int end) {
        if (start == end)
            return new int[]{arr[start]};
        if (start < end) {
            int mid = (start + end) / 2;
            int a[] = mergeSort(arr, start, mid);
            int b[] = mergeSort(arr, mid + 1, end);
            return merge(a, b);
        }
        return new int[]{};
    }

    public static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0, len = a.length + b.length;
        int[] c = new int[len];
        while (k != c.length) {
            if (i == a.length) {
                c[k] = b[j];
                j++;
                k++;
                continue;
            }
            if (j == b.length) {
                c[k] = a[i];
                i++;
                k++;
                continue;
            }
            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
                k++;
            } else {
                c[k] = b[j];
                j++;
                k++;
            }
        }
        return c;
    }

    public static void main(String... args) {
        int[] a = new int[]{2, 5, 1, 7, 4};
        int[] b = new int[]{};
        int[] c = new int[]{1, 2, 4, 5, 7};
        int[] d = new int[]{7, 5, 4, 2, 1};
        int[] e = new int[]{1, 3, 2, 4, 0, 4};
        System.out.println(Arrays.toString(mergeSort(a, 0, a.length - 1)));
        System.out.println(Arrays.toString(mergeSort(b, 0, b.length - 1)));
        System.out.println(Arrays.toString(mergeSort(c, 0, c.length - 1)));
        System.out.println(Arrays.toString(mergeSort(d, 0, d.length - 1)));
        System.out.println(Arrays.toString(mergeSort(e, 0, e.length - 1)));
    }

}
