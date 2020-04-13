package code;

import java.util.Arrays;

public class SimpleQuickSort {

    public static void main(String[] args) {
	// int [] a = new int[] {5, 2, 1, 7, 3, 0};
	int[] a = { 9, 2, 4, 7, 3, 7, 10 };
	// int[] a = { -1, 6, 3, 4, 7, 4 };
	quickSort(a);
	System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr) {
	sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
	if (start >= end) {
	    return;
	}
	int p = start;
	int wall = end;
	for (int i = end; i > start; i--) {
	    if (arr[i] >= arr[p]) {
		swap(arr, i, wall);
		// p = i;
		wall--;
	    }
	}
	/*
	 * int wall = start; for(int i = start+1; i <= end; i++) { if(arr[i] <=
	 * arr[start]) { wall++; swap(arr, i, wall); //p = i; } }
	 */
	swap(arr, wall, start);
	sort(arr, start, wall - 1);
	sort(arr, wall + 1, end);
    }

    private static void swap(int[] arr, int x, int y) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
    }
}
