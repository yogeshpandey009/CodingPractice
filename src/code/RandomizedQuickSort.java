package code;

import java.util.Arrays;

public class RandomizedQuickSort extends QuickSort {

    public RandomizedQuickSort(int[] arr) {
        super(arr);
    }

    public static void main(String... args) {
        int[] arr = {5,2,3,1};//{5, 2, 4, 1, 5, 6, 0, 5};
        RandomizedQuickSort qs = new RandomizedQuickSort(arr);
        System.out.println("Input array:" + Arrays.toString(arr));
        qs.quickSort(0, arr.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr));
        int[] arr2 = {6, 5, 5, 4, 1, 0};
        qs = new RandomizedQuickSort(arr2);
        System.out.println("Input array:" + Arrays.toString(arr2));
        qs.quickSort(0, arr2.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr2));
        int[] arr3 = {5, 7, 6, 5, 4, 5, 2};
        qs = new RandomizedQuickSort(arr3);
        System.out.println("Input array:" + Arrays.toString(arr3));
        qs.quickSort(0, arr3.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr3));
        int[] arr4 = {5, 2, 4, 1, 6, 0};
        qs = new RandomizedQuickSort(arr4);
        System.out.println("Input array:" + Arrays.toString(arr4));
        qs.quickSort(0, arr4.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr4));
    }

    public int getPivot(int start, int end) {
        // Random rand = new Random();
        // nextInt is normally exclusive of the top value, so add 1 to make it
        // inclusive
        // int p = rand.nextInt((end - start) + 1) + start;
        int p = (int) (Math.random() * (end - start + 1)) + start;
        return p;
    }

}
