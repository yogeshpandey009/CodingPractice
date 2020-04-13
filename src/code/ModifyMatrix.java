package code;

public class ModifyMatrix {

    public static void main(String... args) {
	int[][] arr = { { 0, 10, 20, 30 }, { 0, 10, 20, 30 },
		{ 14, 123, 30, 40 }, { 15, 30, 99, 32 } };

	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[0].length; j++) {
		if (arr[i][j] >= 100) {
		    arr[i][j] = 100;
		    for (int k = i - 1; k >= 0 && arr[k][j] < 100; k--) {
			arr[k][j] = 100;
		    }
		    for (int k = j - 1; k >= 0 && arr[i][k] < 100; k--) {
			arr[i][k] = 100;
		    }
		} else {
		    if (arr[0][j] == 100) {
			arr[i][j] = 100;
		    }
		    if (arr[i][0] == 100) {
			arr[i][j] = 100;
		    }
		}
	    }
	}

	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[0].length; j++) {
		System.out.print(arr[i][j] + "  ");
	    }
	    System.out.println("");
	}
    }
}
