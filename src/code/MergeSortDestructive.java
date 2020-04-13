package code;

import java.util.Arrays;

public class MergeSortDestructive {

    public static void main(String... args) {
	int[] a = new int[] { 2, 5, 1, 7, 4 };
	int[] b = new int[] {};
	int[] c = new int[] { 1, 2, 4, 5, 7 };
	int[] d = new int[] { 7, 5, 4, 2, 1 };
	int[] e = new int[] { 1, 3, 2, 4, 0, 4 };
	mergeSort(a, 0, a.length - 1);
	mergeSort(b, 0, b.length - 1);
	mergeSort(c, 0, c.length - 1);
	mergeSort(d, 0, d.length - 1);
	mergeSort(e, 0, e.length - 1);
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(b));
	System.out.println(Arrays.toString(c));
	System.out.println(Arrays.toString(d));
	System.out.println(Arrays.toString(e));
    }

    public static void mergeSort(int[] arr, int start, int end) {
	if (start < end) {
	    int mid = (start + end) / 2;
	    mergeSort(arr, start, mid);
	    mergeSort(arr, mid + 1, end);
	    merge(arr, start, mid, end);
	}
    }

    private static void merge(int[] arr, int start, int mid, int end) {
	int i = start;
	int j = mid + 1;
	int[] merged = new int[end - start + 1];
	int k = 0;
	while (i <= mid && j <= end) {
	    if (arr[i] <= arr[j]) {
		merged[k] = arr[i];
		i++;
	    } else {
		merged[k] = arr[j];
		j++;
	    }
	    k++;
	}
	while (i <= mid) {
	    merged[k] = arr[i];
	    i++;
	    k++;
	}
	while (j <= end) {
	    merged[k] = arr[j];
	    j++;
	    k++;
	}
	k = 0;
	for (int m = start; m <= end; m++) {
	    arr[m] = merged[k];
	    k++;
	}
    }
}
