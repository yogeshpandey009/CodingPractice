package code;

public class WaterContainer {

    public int maxArea(int[] height) {
	int n = height.length;
	int start = 0;
	int end = n - 1;
	int maxArea = 0;
	if (start < end) {
	    maxArea = Math.max(maxArea, computeArea(height, start, end));
	    if (height[start] <= height[end]) {
		start++;
	    } else {
		end--;
	    }
	}
	return maxArea;
    }

    public int computeArea(int[] height, int start, int end) {
	return (end - start) * Math.min(height[end], height[start]);
    }

    public static void main(String[] args) {
	WaterContainer w = new WaterContainer();
	System.out.println(w.maxArea(new int[] { 1, 1 }));
    }
}
