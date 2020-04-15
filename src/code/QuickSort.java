package code;

import java.util.Arrays;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String... args) {
        int[] arr = {5,2,3,1};//{5, 2, 4, 1, 5, 6, 0, 5};
        QuickSort qs = new QuickSort(arr);
        System.out.println("Input array:" + Arrays.toString(arr));
        qs.quickSort(0, arr.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr));
        int[] arr2 = {6, 5, 5, 4, 1, 0};
        qs = new QuickSort(arr2);
        System.out.println("Input array:" + Arrays.toString(arr2));
        qs.quickSort(0, arr2.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr2));
        int[] arr3 = {5, 7, 6, 5, 4, 5, 2};
        qs = new QuickSort(arr3);
        System.out.println("Input array:" + Arrays.toString(arr3));
        qs.quickSort(0, arr3.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arr3));
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
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
        int pivot = arr[pIndex];
        System.out.println("start " + start + ", end " + end + ", p " + pIndex);
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
        if (arr[start] < pivot) {
            swap(pIndex, start);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("next: " + start + "," + end);
        return start;
    }

    public void quickSort(int start, int end) {
        if (start < end) {
            int pIndex = partition(start, end);
            if (pIndex > start) {
                quickSort(start, pIndex - 1);
            }
            if (pIndex < end) {
                quickSort(pIndex, end);
            }
        }
    }

}
