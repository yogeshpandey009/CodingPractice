package code;

import java.util.Arrays;

public class ArrangeZerosOnes {

    public static void arrangeZeroesOnes(int arr[]) {
        int posFirstOne = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (posFirstOne == -1) {
                    posFirstOne = i;
                }
            } else {
                if (posFirstOne != -1) {
                    arr[posFirstOne] = 0;
                    arr[i] = 1;
                    posFirstOne++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void arrangeZeroesOnesTwos(int arr[]) {
        int posFirstOne = -1;
        int posFirstTwo = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (posFirstOne != -1 && posFirstTwo != -1) {
                    arr[posFirstOne] = 0;
                    posFirstOne++;
                    arr[posFirstTwo] = 1;
                    posFirstTwo++;
                    arr[i] = 2;
                } else if (posFirstOne != -1) {
                    arr[posFirstOne] = 0;
                    posFirstOne++;
                    arr[i] = 1;
                } else if (posFirstTwo != -1) {
                    arr[posFirstTwo] = 0;
                    posFirstTwo++;
                    arr[i] = 2;
                }
            } else if (arr[i] == 1) {
                if (posFirstTwo != -1) {
                    arr[posFirstTwo] = 1;
                    if (posFirstOne == -1) {
                        posFirstOne = posFirstTwo;
                    }
                    posFirstTwo++;
                    arr[i] = 2;
                } else if (posFirstOne == -1) {
                    posFirstOne = i;
                }
            } else {
                if (posFirstTwo == -1) {
                    posFirstTwo = i;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void arrangeZeroesOnesTwosSimple(int arr[]) {
        int posFirstOne = 0;
        int posFirstTwo = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, i, posFirstOne);
                if (arr[i] == 1) {
                    swap(arr, i, posFirstTwo);
                }
                posFirstOne++;
                posFirstTwo++;
            } else if (arr[i] == 1) {
                swap(arr, i, posFirstTwo);
                posFirstTwo++;
            }
        }
        System.out.println(posFirstOne + "," + posFirstTwo);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int x) {
        int temp = arr[i];
        arr[i] = arr[x];
        arr[x] = temp;
    }

    public static void main(String... args) {
        int[] a = new int[]{0, 1, 1, 0, 1, 0};
        int[] b = new int[]{2, 1, 0, 0, 2, 1};
        int[] c = new int[]{0, 2, 0, 2, 1, 1};
        int[] d = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        arrangeZeroesOnes(a);
        arrangeZeroesOnesTwos(b);
        arrangeZeroesOnesTwos(c);
        arrangeZeroesOnesTwos(d);
        // arrangeZeroesOnesTwosSimple(c);
    }
}
