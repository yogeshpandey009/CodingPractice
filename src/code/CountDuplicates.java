package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDuplicates {

    public static void main(String[] args) {
	List<Integer> arr = new ArrayList<Integer>(Arrays.asList(2, 6, 4, 2, 5,
		3, 2, 8, 4));
	System.out.println(countDuplicates(arr));
    }

    public static int countDuplicates(List<Integer> arr) {
	int count = 0;
	Set<Integer> set = new HashSet<Integer>();
	for (Integer i : arr) {
	    if (!set.add(i)) {
		count++;
	    }
	}
	return count;
    }

}
