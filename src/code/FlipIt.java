package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FlipIt {

    public static void main(String... args) {
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("flipit/in3.txt"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	File file = new File("flipit/out3.txt");
	try {
	    if (!file.exists()) {
		file.createNewFile();
	    }

	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
	    StringBuilder sb = new StringBuilder();
	    int i = 1;
	    int n = sc.nextInt();
	    sc.nextLine();
	    while (i <= n) {
		String s = sc.nextLine();
		int result = solution(s);
		sb.append("Case #").append(i + "").append(": ")
			.append(result + "\n");
		i++;
	    }

	    bw.write(sb.toString());
	    bw.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static int solution(String s) {
	int result = 0;
	char[] c_arr = s.toCharArray();
	char prev = c_arr[0];
	int l = c_arr.length;
	for (int i = 1; i < l; i++) {
	    char c = c_arr[i];
	    if (c != prev) {
		result++;
	    }
	    prev = c;
	}
	if (prev == '-') {
	    result++;
	}
	return result;
    }
}
