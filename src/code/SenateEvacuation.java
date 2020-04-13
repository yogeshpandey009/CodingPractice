package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SenateEvacuation {

    public static void main(String[] args) {
	Scanner sc = null;
	try {
	    sc = new Scanner(new File("senate/in3.txt"));
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	File file = new File("senate/out3.txt");
	try {
	    if (!file.exists()) {
		file.createNewFile();
	    }

	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
	    StringBuilder sb = new StringBuilder();
	    int i = 1;
	    int t = sc.nextInt();
	    while (i <= t) {
		PriorityQueue<Party> heap = new PriorityQueue<Party>();
		int n = sc.nextInt();
		int j = 1;
		while (j <= n) {
		    heap.add(new Party((char) (j + 64), sc.nextInt()));
		    j++;
		}
		String result = solution(heap);
		sb.append("Case #").append(i + ": ").append(result + "\n");
		i++;
	    }

	    bw.write(sb.toString());
	    bw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    static class Party implements Comparable<Party> {

	Character name;
	Integer membersCount;

	public Party(Character name, Integer membersCount) {
	    super();
	    this.name = name;
	    this.membersCount = membersCount;
	}

	@Override
	public int compareTo(Party anotherParty) {
	    return anotherParty.membersCount.compareTo(this.membersCount);
	}

	@Override
	public String toString() {
	    return "Party [name=" + name + ", membersCount=" + membersCount
		    + "]";
	}

    }

    public static String solution(PriorityQueue<Party> parties) {
	// for(Party p : parties) {
	// System.out.println(p);
	// }
	StringBuilder sb = new StringBuilder();
	while (!parties.isEmpty()) {
	    Party max = parties.poll();
	    Party secondMax = parties.poll();
	    if (max.membersCount == secondMax.membersCount) {
		if (max.membersCount == 1 && !parties.isEmpty()) {
		    max.membersCount--;
		    sb.append(max.name + " ");
		    parties.add(secondMax);
		    continue;
		}
		max.membersCount--;
		secondMax.membersCount--;
		sb.append(max.name + "" + secondMax.name + " ");
	    } else {
		max.membersCount -= 2;
		sb.append(max.name + "" + max.name + " ");
	    }
	    if (max.membersCount > 0) {
		parties.add(max);
	    }
	    if (secondMax.membersCount > 0) {
		parties.add(secondMax);
	    }
	}
	return sb.toString().trim();
    }

}
