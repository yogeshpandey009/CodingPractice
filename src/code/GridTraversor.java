package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class GridTraversor {

    public static void main(String[] args) {
	Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
		System.in)));
	int T = sc.nextInt();
	for (int t = 1; t <= T; t++) {
	    int R = sc.nextInt();
	    int C = sc.nextInt();
	    solve(t, R, C);
	}
	sc.close();
    }

    public static void solve(int t, int r, int c) {
	LinkedList<String> pathSoFar = new LinkedList<String>();
	Set<String> positions = new HashSet<String>();

	for (int m = 0; m < r; m++) {
	    for (int n = 0; n < c; n++) {
		positions.add(m + "," + n);
	    }
	}
	dfs(0, 0, r, c, pathSoFar, positions);
	if (pathSoFar.size() == r * c) {
	    System.out.println("Case #" + t + ": POSSIBLE");
	    for (String path : pathSoFar) {
		System.out.println(path);
	    }
	} else {
	    System.out.println("Case #" + t + ": IMPOSSIBLE");
	}
    }

    private static void dfs(int x, int y, int r, int c,
	    LinkedList<String> pathSoFar, Set<String> positions) {
	pathSoFar.addLast((x + 1) + " " + (y + 1));
	if (pathSoFar.size() == r * c)
	    return;
	String key = x + "," + y;
	positions.remove(key);
	for (String pos : positions.toArray(new String[0])) {
	    String[] parts = pos.split(",");
	    int i = Integer.parseInt(parts[0]);
	    int j = Integer.parseInt(parts[1]);
	    if (i != x && j != y && i - j != x - y && i + j != x + y) {
		dfs(i, j, r, c, pathSoFar, positions);
		if (pathSoFar.size() == r * c)
		    return;
	    }
	}
	positions.add(key);
	pathSoFar.removeLast();
	return;
    }

}