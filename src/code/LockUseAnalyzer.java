package code;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LockUseAnalyzer {

    public static int analyze(String[] input) {
	Stack<Integer> stack = new Stack<Integer>();
	Set<Integer> set = new HashSet<Integer>();
	int i = 0;
	for (; i < input.length; i++) {
	    String s = input[i];
	    if (s.contains("ACQUIRE")) {
		int val = Integer.parseInt(s.replace("ACQUIRE ", ""));
		if (!set.contains(val)) {
		    stack.push(val);
		    set.add(val);
		} else {
		    return i + 1;
		}
	    } else {
		int val = Integer.parseInt(s.replace("RELEASE ", ""));
		if (stack.peek() == val) {
		    stack.pop();
		    set.remove(val);
		} else {
		    return i + 1;
		}
	    }
	}
	return stack.size() == 0 ? 0 : i + 1;
    }

    public static void main(String[] args) {

	// String[] arr = {"ACQUIRE 364", "ACQUIRE 84", "RELEASE 84",
	// "RELEASE 84"};
	// String[] arr = {"ACQUIRE 364", "ACQUIRE 84", "RELEASE 364",
	// "RELEASE 84"};
	// String[] arr = {"ACQUIRE 364", "ACQUIRE 84", "RELEASE 84",
	// "RELEASE 364"};
	// String[] arr = {"ACQUIRE 123", "ACQUIRE 364", "ACQUIRE 84",
	// "RELEASE 84", "RELEASE 364" , "RELEASE 123"};
	String[] arr = { "ACQUIRE 123", "ACQUIRE 364", "ACQUIRE 84",
		"RELEASE 84", "RELEASE 364", "ACQUIRE 456" };
	System.out.println(analyze(arr));
    }

}
