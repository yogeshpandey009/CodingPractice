package code;

import java.util.Arrays;

public class QS
{
    public static void main(String[] args)
    {
        // This is unsorted array
        Integer[] array = new Integer[] { 10,9,8,8,3,3,11 };

        // Let's sort using quick sort
        quickSort( array, 0, array.length - 1 );

        // Verify sorted array
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(Integer[] arr, int low, int high)
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }

        if (low >= high){
            return;
        }

        //Get the pivot element from the middle of the list
        //int middle = low + (high - low) / 2;
        int pivot = arr[low];

        System.out.print("low " + low + ", high " + high + ", p " + low
                + ": ");

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i < j)
        {
            //Check until all values on left side array are lower than pivot
            while (i < j && arr[i] < pivot)
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (i < j && arr[j] > pivot)
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
            if (i < j)
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort(arr, low, j);
        }
        if (high > i){
            quickSort(arr, i, high);
        }
    }

    public static void swap (Integer array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}