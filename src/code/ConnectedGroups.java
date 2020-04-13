package code;

import java.util.HashSet;
import java.util.Set;

public class ConnectedGroups {

    public static void main(String[] args) {
	// String[][] input = {
	// {"Y", "Y", "Y", "N"} ,
	// {"Y", "Y", "N", "N"},
	// {"Y", "N", "Y", "N"},
	// {"N", "N", "N", "Y"}};
	// String[][] input = {
	// {"Y", "N", "N", "Y"} ,
	// {"N", "Y", "N", "Y"},
	// {"N", "N", "Y", "N"},
	// {"Y", "Y", "N", "Y"}};
	String[][] input = { { "Y", "N", "N", "Y", "N" },
		{ "N", "Y", "Y", "N", "N" }, { "N", "Y", "Y", "N", "Y" },
		{ "Y", "N", "N", "Y", "Y" }, { "N", "N", "Y", "Y", "Y" } };
	int n = input.length;
	int[] arr = new int[n];
	for (int i = 0; i < n; i++)
	    arr[i] = i;
	for (int i = 0; i < n; i++) {
	    for (int j = 0; j < i; j++) {
		if (input[i][j].equals("Y")) {

		}
	    }
	}
	Set<Integer> set = new HashSet<Integer>();
	for (int i = 0; i < n; i++) {
	    set.add(arr[i]);
	    System.out.println(arr[i]);
	}
	// System.out.println(set.size());
    }
}
