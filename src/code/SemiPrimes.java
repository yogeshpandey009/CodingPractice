package code;

import java.util.Arrays;

public class SemiPrimes {

    public static void main(String[] args) {
    }

    public static int[] CountSemiPrimes(int N, int[] P, int[] Q) {
	boolean[] co_primes = new boolean[N + 1];
	boolean[] semiprimes = new boolean[N + 1];
	for (int i = 2; i <= N / 2; i++) {
	    for (int j = 2; j <= i && i * j <= N; j++) {
		co_primes[i * j] = true;
		if (co_primes[i] == false && co_primes[j] == false) {
		    semiprimes[i * j] = true;
		}
	    }
	}
	int[] count_l = new int[semiprimes.length];
	int prev = 0;
	for (int i = 0; i < semiprimes.length; i++) {
	    if (semiprimes[i] == true) {
		count_l[i] = prev + 1;
	    } else {
		count_l[i] = prev;
	    }
	    prev = count_l[i];
	}
	int result[] = new int[P.length];
	for (int i = 0; i < P.length; i++) {
	    int count = count_l[Q[i]] - count_l[P[i]];
	    if (semiprimes[P[i]])
		count++;
	    result[i] = count;
	}
	return result;
    }
}
