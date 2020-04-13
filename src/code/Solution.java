package code;

import java.util.*;

class Solution {
    public static void main(String[] args) {
	/*
	 * Scanner sc = new Scanner(System.in); List<Integer> prices = new
	 * ArrayList<Integer>(); while(sc.hasNext()) { prices.add(sc.nextInt());
	 * }
	 */
	int[] prices = { 993, 543, 757, 113, 584, 817, 582, 638, 174, 368, 830,
		97, 715, 175 };
	// int[] prices = { 4, 3, 2, 1};
	// int[] prices = {1,2,3,4};
	// int[] prices = {1,2,3,4,-5};
	// int[] prices = {3, 4, 1, 4, 5};
	MaxProfit(prices);
    }

    public static void MaxProfit(int[] prices) {
	int[] diff_arr = new int[prices.length - 1];
	if (prices.length > 0) {
	    int prev = prices[0];
	    for (int i = 1; i < prices.length; i++) {
		int next = prices[i];
		diff_arr[i - 1] = prices[i] - prev;
		prev = next;
	    }
	    System.out.println(Arrays.toString(diff_arr));
	    // MaxSubArraySum(diff_arr);
	    MaxSumSoFar(diff_arr);
	    // strictlyInc(diff_arr);
	}
    }

    public static void MaxSubArraySum(int[] arr) {
	int sum = arr[0];
	int max = arr[0];
	int temp_buy = 0;
	int buy = 0;
	int sell = 0;
	for (int i = 1; i < arr.length; i++) {
	    if (sum < 0) {
		sum = arr[i];
		temp_buy = i;
	    } else {
		sum += arr[i];
	    }
	    if (sum > max) {
		max = sum;
		buy = temp_buy;
		sell = i;
	    }
	}
	// System.out.println(max);
	System.out.println(buy + " BUY");
	System.out.println(sell + 1 + " SELL");
    }

    public static void MaxSumSoFar(int[] arr) {
	ArrayList<String> result = new ArrayList<String>();
	int sum = 0;
	int buy = -1;
	for (int i = 0; i < arr.length; i++) {
	    if (sum + arr[i] > sum) {
		sum += arr[i];
		if (buy == -1)
		    buy = i;
	    } else {
		if (buy != -1) {
		    result.add(buy + " BUY");
		    result.add(i + " SELL");
		}
		sum = 0;
		buy = -1;
	    }
	}
	if (buy != -1) {
	    result.add(buy + " BUY");
	    result.add(arr.length + " SELL");
	}

	for (String r : result)
	    System.out.println(r);
    }

    public static void strictlyInc(int[] arr) {
	ArrayList<String> result = new ArrayList<String>();
	int buy = -1;
	int sell = -1;
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] > 0) {
		if (buy == -1) {
		    buy = i;
		}
		sell = i + 1;
	    } else {
		if (buy != -1) {
		    result.add(buy + " BUY");
		    result.add(sell + " SELL");
		}
		buy = -1;
		sell = -1;
	    }
	}
	if (buy != -1) {
	    result.add(buy + " BUY");
	    result.add(sell + " SELL");
	}
	for (String r : result)
	    System.out.println(r);
    }
}
