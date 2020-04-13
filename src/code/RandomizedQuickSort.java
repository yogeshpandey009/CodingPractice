package code;

import java.util.Arrays;

public class RandomizedQuickSort extends QuickSort {

    public RandomizedQuickSort(int[] arr) {
	super(arr);
    }

    public int getPivot(int start, int end) {
	// Random rand = new Random();
	// nextInt is normally exclusive of the top value, so add 1 to make it
	// inclusive
	// int p = rand.nextInt((end - start) + 1) + start;
	int p = (int) (Math.random() * (end - start + 1)) + start;
	return p;
    }

    public static void main(String... args) {
	int[] arr = { 5, 2, 4, 1, 6, 0 };
	RandomizedQuickSort qs = new RandomizedQuickSort(arr);
	System.out.println("Input array:" + Arrays.toString(arr));
	qs.quickSort(0, arr.length - 1);
	System.out.println("Sorted array:" + Arrays.toString(arr));
    }

}
