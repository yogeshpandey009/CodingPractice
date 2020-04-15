package code;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MinHeapSortTest {

    @Test
    public void testNormalSort() {
        int[] arr = {5, 3, 1, 6, 8, 3};
        MinHeapSort heap = new MinHeapSort(arr);
        heap.sort();
        int[] sorted = {8, 6, 5, 3, 3, 1};
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testEmpty() {
        int[] arr = {};
        MinHeapSort heap = new MinHeapSort(arr);
        heap.sort();
        int[] sorted = {};
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {8, 6, 5, 3, 3, 1};
        MinHeapSort heap = new MinHeapSort(arr);
        heap.sort();
        int[] sorted = {8, 6, 5, 3, 3, 1};
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {1, 3, 3, 5, 6, 8};
        MinHeapSort heap = new MinHeapSort(arr);
        heap.sort();
        int[] sorted = {8, 6, 5, 3, 3, 1};
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testAllNegatives() {
        int[] arr = {-5, -3, -1, -6, -8, -3};
        MinHeapSort heap = new MinHeapSort(arr);
        heap.sort();
        int[] sorted = {-1, -3, -3, -5, -6, -8};
        assertArrayEquals(sorted, arr);
    }

    @Test
    public void testPeekMin() {
        int[] arr = {5, 3, 1, 6, 8, 3};
        MinHeapSort heap = new MinHeapSort(arr);
        int min = heap.peekMin();
        assertEquals(1, min);
        min = heap.peekMin();
        assertEquals(1, min);
    }

    @Test
    public void testExtractMin() {
        int[] arr = {5, 3, 1, 6, 8, 3};
        MinHeapSort heap = new MinHeapSort(arr);
        int min = heap.extractMin();
        assertEquals(1, min);
        min = heap.extractMin();
        assertEquals(3, min);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        new MinHeapSort(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testHeapUnderflow() {
        int[] arr = {5};
        MinHeapSort heap = new MinHeapSort(arr);
        int min = heap.extractMin();
        assertEquals(5, min);
        min = heap.extractMin();
    }

}
