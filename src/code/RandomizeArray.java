package code;

public class RandomizeArray {

    public static void main(String... args) {
	int[] arr = new int[] { 2, 4, 6, 1, 9 };
	int n = arr.length;
	int[] pos = new int[n];
	int[] out = new int[n];

	for (int i = 0; i < n; i++) {
	    pos[i] = i;
	}

	for (int i = 0; i < n; i++) {
	    int x = generateRandom(pos, n - i - 1);
	    System.out.println("Random No. " + x);
	    out[x] = arr[i];
	    display(out);
	}
    }

    public static void display(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + " ");
	}
	System.out.println("");
    }

    public static int generateRandom(int[] pos, int n) {
	int i = (int) (Math.random() * n);
	int temp = pos[i];
	pos[i] = pos[n];
	pos[n] = temp;
	return temp;
    }

}
