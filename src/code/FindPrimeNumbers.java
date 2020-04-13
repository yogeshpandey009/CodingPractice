package code;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeNumbers {

    public static void main(String[] args) {
        System.out.println(findPrimeNumbers(100));
    }

    public static List<Integer> findPrimeNumbers(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        int x = 0;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i] == true) {
                // for(int j = i * i; j < n; j=j+i) {
                // isPrime[j] = false;
                // x++;
                // }
                for (int j = i; i * j < n; j++) {
                    isPrime[i * j] = false;
                    x++;
                }
            }
        }
        System.out.println(x);
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

}
