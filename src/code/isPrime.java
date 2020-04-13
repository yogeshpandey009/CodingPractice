package code;

public class isPrime {
    public static void main(String... args) {
	System.out.println(isPrime(37));
	System.out.println(isPrime(83));
	System.out.println(isPrime(49));
    }

    public static int isPrime(int num) {
	for (int i = 2; i <= Math.sqrt(num); i++) {
	    if (num % i == 0) {
		return i;
	    }
	}
	return 1;
    }

}
