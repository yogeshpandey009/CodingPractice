package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicoNumbers {

    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static List<Integer> lexicalOrder(int n) {
	List<Integer> result = new ArrayList<>(n);
	int digits = Integer.toString(n).length();
	for (int i = 1; i <= digits; i++) {
	    generateNumber(i);
	}
	for (Integer i : map.get(digits)) {
	    if (i < n) {
		result.add(i);
	    }
	}
	return result;
    }

    private static void generateNumber(int d) {
	ArrayList<Integer> list = new ArrayList<>();
	if (d == 1) {
	    for (int i = 0; i < 10; i++) {
		list.add(i);
	    }
	} else {
	    for (Integer s : map.get(d - 1)) {
		for (int i = 1; i < 10; i++) {
		    list.add(Integer.parseInt(i + "" + s));
		}
	    }
	}
	map.put(d, list);
    }

    public static void main(String[] args) {
	System.out.println(lexicalOrder(13));
    }
}
