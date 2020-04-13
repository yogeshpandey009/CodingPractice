package code;

public class Selection {
    private static int getMedian(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int median = n >> 1;
        int k = -1;
        while (k != median) {
            if (k < median) {
                start = k + 1;
            } else {
                end = k - 1;
            }
            k = partition(arr, start, end);
        }
        return arr[median];
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (j == start)
            return j;
        swap(arr, start, j);
        return j;
    }

    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 2, 4};
        /*
         * Scanner sc = new Scanner(System.in); int n = sc.nextInt(); int []arr
         * = new int[n]; for(int i = 0; i < n; i++) { arr[i] = sc.nextInt(); }
         */
        System.out.println(getMedian(arr));
    }
}
