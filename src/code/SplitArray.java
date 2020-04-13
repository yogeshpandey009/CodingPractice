package code;

import java.util.HashMap;
import java.util.Map;

public class SplitArray {

    long bSum = 0;
    int bSize = 0;
    long sum = 0;

    Map<Integer, Boolean> dp = new HashMap<>();

    public boolean splitArraySameAverage(int[] A) {
	if (A.length <= 1)
	    return false;

	for (int a : A)
	    sum += a;

	return dfs(A, 0, 0);
    }

    private boolean dfs(int[] A, int st, int visited) {
	if (st == A.length)
	    return false;

	if (dp.containsKey(visited))
	    return dp.get(visited);
	float bAvg = (float) bSum / bSize;
	float cAvg = ((float) (sum - bSum)) / (A.length - bSize);

	if (bAvg == cAvg) {
	    System.out.println(bSum);
	    System.out.println(bAvg);
	    return true;
	}

	bSize++;
	bSum += A[st];

	visited |= 1 << st;
	boolean found = dfs(A, st + 1, visited);

	if (found) {
	    return true;
	}

	bSum -= A[st];
	bSize--;
	visited &= ~(1 << st);

	found = dfs(A, st + 1, visited);

	dp.put(visited, found);
	return found;
    }

    public static void main(String[] args) {
	System.out.println(new SplitArray().splitArraySameAverage(new int[] {
		5, 16, 4, 11, 4 }));
	System.out.println(new SplitArray().splitArraySameAverage(new int[] {
		10, 29, 13, 53, 33, 48, 76, 70, 5, 5 }));
	// System.out.println(new SplitArray().splitArraySameAverage(new int[]
	// {60,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30,30}));
	// []
    }
}