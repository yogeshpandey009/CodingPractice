package code;

import java.util.Stack;

public class FishAlive {

    public static void main(String[] args) {
	int ans = solution(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0,
		0 });
	System.out.println(ans);
    }

    public static int solution(int[] A, int[] B) {
	Stack<Integer> fishes = new Stack<Integer>();
	fishes.push(0);
	for (int f = 1; f < B.length; f++) {
	    if (fishes.isEmpty()) {
		fishes.push(f);
	    } else {
		Integer p = fishes.peek();
		if (B[p] == 1 && B[f] == 0) {
		    if (A[p] < A[f]) {
			fishes.pop();
			f--;
		    }
		} else {
		    fishes.push(f);
		}
	    }
	}
	return fishes.size();
    }

}
