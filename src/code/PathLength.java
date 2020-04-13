package code;

import java.util.Stack;

public class PathLength {

    public static int lengthLongestPath(String input) {
	if (input == null || "".equals(input)) {
	    return 0;
	}
	int maxSoFar = 0;
	String[] inputs = input.split("\n");
	Stack<Integer> stack = new Stack<>();
	int prevDepth = -1;
	int pathLength = 0;
	for (String s : inputs) {
	    String[] arr = s.split("\t");
	    int depth = arr.length - 1;
	    String curr = arr[depth];
	    if (depth <= prevDepth) {
		int times = prevDepth - depth + 1;
		while (times != 0) {
		    stack.pop();
		    times--;
		}
		if (stack.isEmpty()) {
		    pathLength = 0;
		} else {
		    pathLength = stack.peek();
		}
	    }
	    pathLength += curr.length();
	    stack.push(pathLength);

	    if (s.contains("")) {
		int fullPath = pathLength + depth;
		if (fullPath > maxSoFar) {
		    maxSoFar = fullPath;
		}
	    }
	    prevDepth = depth;
	}

	return maxSoFar;

    }

    public static void main(String[] args) {
	System.out.println(lengthLongestPath("dir\n    file.txt"));
    }
}