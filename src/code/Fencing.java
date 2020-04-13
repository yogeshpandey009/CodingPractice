package code;

import java.util.*;

public class Fencing {

    public int solution(int[] A, int X) {
	HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
	List<Integer> lengths = new ArrayList<Integer>();
	for (int a : A) {
	    if (freqMap.containsKey(a)) {
		freqMap.put(a, freqMap.get(a) + 1);
	    } else {
		freqMap.put(a, 1);
	    }
	}
	double result = 0;
	for (int k : freqMap.keySet()) {
	    if (freqMap.get(k) >= 2) {
		lengths.add(k);
		if (freqMap.get(k) >= 4) {
		    if (k * k >= X) {
			result++;
		    }
		}
	    }
	}
	Collections.sort(lengths);
	int l = 0;
	int r = lengths.size() - 1;
	while (l < r) {
	    int left = lengths.get(l);
	    int right = lengths.get(r);
	    // System.out.println(left + " - " + right + "->" + left * right);
	    if (left * right < X) {
		l++;
	    } else {
		result += r - l;
		if (result > 1000000000)
		    return -1;
		r--;
	    }
	}
	return (int) result;
    }
}