package code;

class ClosestPair {
    // ar1[0..m-1] and ar2[0..n-1] are two given sorted
    // arrays/ and x is given number. This function prints
    // the pair from both arrays such that the sum of the
    // pair is closest to x.
    void printClosest(int ar1[], int ar2[], int m, int n, int x) {
	// Initialize the diff between pair sum and x.
	int diff = Integer.MAX_VALUE;

	// res_l and res_r are result indexes from ar1[] and ar2[]
	// respectively
	int res_l = 0, res_r = 0;

	// Start from left side of ar1[] and right side of ar2[]
	int l = 0, r = n - 1;
	while (l < m && r >= 0) {
	    // If sum of this pair is more than x, move to smaller
	    // side
	    if (ar1[l] + ar2[r] > x)
		r--;
	    else // move to the greater side
	    {
		// If this pair is closer to x than the previously
		// found closest, then update res_l, res_r and diff
		if (Math.abs(ar1[l] + ar2[r] - x) <= diff) {
		    res_l = l;
		    res_r = r;
		    diff = Math.abs(ar1[l] + ar2[r] - x);
		}
		l++;
	    }
	}

	// Print the result
	System.out.print("The closest pair is [" + ar1[res_l] + ", "
		+ ar2[res_r] + "]");
    }

    // Driver program to test above functions
    public static void main(String args[]) {
	ClosestPair ob = new ClosestPair();
	int ar1[] = { 1, 2, 3, 4, 5 };
	int ar2[] = { 6, 7 };
	int m = ar1.length;
	int n = ar2.length;
	int x = 10;
	ob.printClosest(ar1, ar2, m, n, x);
    }
}