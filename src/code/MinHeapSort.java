package code;

import java.util.Arrays;

public class MinHeapSort {

    private int[] input;

    private int size = 0;

    MinHeapSort(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException();
        input = arr;
        size = input.length;
        buildHeap();
    }

    public MinHeapSort(int size) {
        input = new int[size];
    }

    public static void main(String[] args) {
        // int [] arr = { 5, 3, 6, 1, 8, 2};
        // int [] arr = { 1, 2, 3, 4, 5, 6, 7};
        // int [] arr = { 7, 6, 5, 4, 3, 2, 1};
        int[] arr = {5, 6, 3, 1, 8, 2, 4};
        MinHeapSort heap = new MinHeapSort(arr);
        System.out.println("Heap: " + Arrays.toString(arr));
        heap.sort();
        System.out.println("Sorted: " + Arrays.toString(arr));
        heap = new MinHeapSort(7);
        heap.insert(5);
        heap.insert(6);
        heap.insert(3);
        heap.insert(1);
        heap.insert(8);
        heap.insert(2);
        heap.insert(4);
        arr = heap.getMinHeap();
        System.out.println("Heap: " + Arrays.toString(arr));
        heap.sort();
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

    private void downHeapify(int idx) {
        int left = getLeft(idx);
        int right = getRight(idx);
        int min = idx;
        if (left < size && input[left] < input[idx]) {
            min = left;
        }
        if (right < size && input[right] < input[min]) {
            min = right;
        }
        if (min != idx) {
            swap(min, idx);
            downHeapify(min);
        }
    }

    private void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    private void removeLast() {
        if (size == 0)
            throw new IllegalStateException("Heap Underflow");
        size--;
    }

    public int peekMin() {
        if (size == 0)
            throw new IllegalStateException("Heap Underflow");
        return input[0];
    }

    public int extractMin() {
        int min = peekMin();
        swap(0, size - 1);
        removeLast();
        downHeapify(0);
        return min;
    }

    public void insert(int x) {
        if (size == input.length) {
            throw new IllegalStateException("Heap Overflow");
        }
        input[size] = x;
        size++;
        int curr = size - 1;
        int p = getParent(curr);
        while (input[p] > input[curr] && p >= 0) {
            swap(p, curr);
            curr = p;
            p = getParent(p);
        }
    }

    public void sort() {
        for (int i = 0; i < input.length - 1; i++) {
            swap(0, size - 1);
            removeLast();
            downHeapify(0);
        }
    }

    private int getLeft(int idx) {
        return (2 * idx) + 1;
    }

    private int getRight(int idx) {
        return (2 * idx) + 2;
    }

    private int getParent(int idx) {
        return (idx - 1) / 2;
    }

    private void swap(int x, int y) {
        int temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    public int[] getMinHeap() {
        return input;
    }
}
