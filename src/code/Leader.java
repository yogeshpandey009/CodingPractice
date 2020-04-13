package code;

public class Leader {

    public static void main(String... args) {
	int c = findLeader(new int[] { 2, 2, 5 });
	System.out.println(c);
    }

    public static int findLeader(int[] A) {
	int size = 0;
	int candidate = -1;
	int leader = -1;
	int count = 0;
	for (int i = 0; i < A.length; i++) {
	    if (size == 0) {
		candidate = A[i];
		size++;
	    } else {
		if (candidate != A[i]) {
		    size--;
		} else {
		    size++;
		}
	    }
	}
	if (size > 0) {
	    leader = candidate;
	}
	for (int i = 0; i < A.length; i++) {
	    if (leader == A[i])
		count++;
	}
	if (count > (A.length / 2))
	    return leader;
	return -1;
    }

    public int findEquiLeaders(int[] A) {
	int len = A.length;
	int size = 0;
	int candidate = -1;
	for (int i = 0; i < len; i++) {
	    if (size == 0) {
		candidate = A[i];
		size++;
	    } else {
		if (candidate != A[i]) {
		    size--;
		} else {
		    size++;
		}
	    }
	}
	if (size > 0) {
	    int count = 0;
	    int leader = -1;
	    for (int i = 0; i < len; i++) {
		if (A[i] == candidate)
		    count++;
	    }
	    if (count > len / 2) {
		leader = candidate;
	    }
	    int c_left = 0;
	    int ans = 0;
	    for (int i = 0; i < len; i++) {
		if (leader == A[i])
		    c_left++;
		if (c_left > (i + 1) / 2
			&& (count - c_left) > (len - i - 1) / 2) {
		    ans++;
		}
	    }
	    return ans;
	}
	return 0;
    }

}
