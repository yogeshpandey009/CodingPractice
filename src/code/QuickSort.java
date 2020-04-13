package code;

import java.util.Arrays;

public class QuickSort {

    private int[] arr;

    public int[] getArr() {
	return arr;
    }

    public void setArr(int[] arr) {
	this.arr = arr;
    }

    public QuickSort(int[] arr) {
	this.arr = arr;
    }

    public int getPivot(int start, int end) {
	return start;
    }

    private void swap(int x, int y) {
	int temp;
	temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
    }

    public int partition(int start, int end) {
	int pIndex = getPivot(start, end);
	System.out.print("start " + start + ", end " + end + ", p " + pIndex
		+ ": ");
	int pivot = arr[pIndex];
	while (start < end) {
	    // skip smaller in left
	    while (start < end && arr[start] <= pivot) {
		start++;
	    }
	    // skip larger in right
	    while (start < end && arr[end] >= pivot) {
		end--;
	    }
	    if (start < end) {
		swap(start, end);
	    }
	}
	swap(pIndex, start - 1);
	System.out.println(Arrays.toString(arr));
	return start - 1;
    }

    public void quickSort(int start, int end) {
	if (start != end) {
	    int pIndex = partition(start, end);
	    if (pIndex > start) {
		quickSort(start, pIndex - 1);
	    }
	    if (pIndex < end) {
		quickSort(pIndex + 1, end);
	    }
	}
    }

    public static void main(String... args) {
	int[] arr = { 5, 2, 4, 1, 5, 6, 0 };
	QuickSort qs = new QuickSort(arr);
	System.out.println("Input array:" + Arrays.toString(arr));
	qs.quickSort(0, arr.length - 1);
	System.out.println("Sorted array:" + Arrays.toString(arr));
    }

}
