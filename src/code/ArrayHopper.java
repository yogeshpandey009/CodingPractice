package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ArrayHopper {
    private static Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
    private static Map<Integer, Integer> backtrack = new HashMap<Integer, Integer>();

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> data = new ArrayList<Integer>();
        try {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                Integer i = Integer.parseInt(line);
                if (i >= 0)
                    data.add(i);
                else
                    throw new Exception();
            }
            if (data.size() == 0)
                throw new Exception();
            Integer steps = findHops(data, 0);
            if (steps == -1)
                throw new Exception();
            else
                display();
        } catch (Exception e) {
            System.out.println("failure");
        } finally {
            sc.close();
        }
    }

    private static Integer findHops(List<Integer> arr, int curr) {
        if (curr >= arr.size())
            return 0;
        int furthestHop = arr.get(curr);
        if (furthestHop == 0)
            return -1;
        else {
            if (!dp.containsKey(curr)) {
                Integer minSteps = Integer.MAX_VALUE;
                Integer minStepsPath = -1;
                for (int i = furthestHop; i > 0; i--) {
                    Integer steps = findHops(arr, curr + i);
                    if (steps != -1 && minSteps > steps) {
                        minSteps = steps;
                        minStepsPath = curr + i;
                        if (minSteps == 0)
                            break;
                    }
                }
                if (minStepsPath != -1) {
                    backtrack.put(curr, minStepsPath);
                    dp.put(curr, minSteps + 1);
                } else {
                    dp.put(curr, -1);
                }
            }
            return dp.get(curr);
        }
    }

    private static void display() {
        int start = 0;
        StringBuilder sb = new StringBuilder();
        while (backtrack.containsKey(start)) {
            sb.append(start + ", ");
            start = backtrack.get(start);
        }
        sb.append("out");
        System.out.print(sb.toString());
    }
}
/*
 * ArrayList<Integer> numbers = null; try { numbers = readFromConsole(); }
 * catch(Exception e) { System.out.println("failure"); return; } if
 * (numbers.size() > 0) { int[] minHopArray = new int[numbers.size()];
 *
 * initializeMinHopArray(numbers, minHopArray);
 *
 * calculateMinHop(numbers, minHopArray);
 *
 * printSolution(numbers, minHopArray); } else { System.out.println("failure");
 * } }
 *
 * private static ArrayList<Integer> readFromConsole() throws Exception {
 * ArrayList<Integer> numbers = new ArrayList<>();
 *
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * String line;
 *
 * while ((line = br.readLine()) != null && line.length() != 0) { int num =
 * Integer.parseInt(line); if(num >=0) { numbers.add(num); } else { throw new
 * Exception(); } }
 *
 * return numbers; }
 *
 * private static void initializeMinHopArray(ArrayList<Integer> numbers, int[]
 * minHopArray) { for (int i = 0; i < numbers.size(); i++) { minHopArray[i] =
 * Integer.MAX_VALUE; }
 *
 * if (numbers.get(numbers.size() - 1) != 0) { minHopArray[numbers.size() - 1] =
 * 1; } }
 *
 * private static void printSolution(ArrayList<Integer> numbers, int[]
 * minHopArray) { if (minHopArray[0] == Integer.MAX_VALUE) {
 * System.out.println("failure"); } else {
 *
 * ArrayList<Integer> minIndicesList = findMinIndicesList(minHopArray, 0,
 * numbers.size() - 1);
 *
 * for (int i = minIndicesList.size() - 1; i >= 0; i--) {
 * System.out.print(minIndicesList.get(i) + ", "); } System.out.print("out"); }
 * }
 *
 * private static void printArray(int[] minHopArray) { for (int aMinHopArray :
 * minHopArray) { System.out.print(aMinHopArray + ", "); }
 * System.out.println(""); }
 *
 * private static void calculateMinHop(ArrayList<Integer> numbers, int[]
 * minHopArray) {
 *
 * for (int i = numbers.size() - 2; i >= 0; i--) { int valueAtIndex =
 * numbers.get(i);
 *
 * if (valueAtIndex == 0) { minHopArray[i] = Integer.MAX_VALUE; } else if (i +
 * valueAtIndex >= numbers.size()) { minHopArray[i] = 1; } else if (valueAtIndex
 * < 0) { minHopArray[i] = Integer.MAX_VALUE; } else { int integerMax =
 * minHopArray[i + valueAtIndex]; if (integerMax == Integer.MAX_VALUE) {
 * minHopArray[i] = Integer.MAX_VALUE; } else { minHopArray[i] = 1 + integerMax;
 * } } } }
 *
 * private static ArrayList<Integer> findMinIndicesList(int[] minHopArray, int
 * start, int end) { ArrayList<Integer> reverseList = new ArrayList<>();
 *
 * int min;
 *
 * while (start <= end) { min = findMinIndex(minHopArray, start, end);
 * reverseList.add(min); end = min - 1; }
 *
 * return reverseList; }
 *
 * private static int findMinIndex(int[] minHopArray, int start, int end) { int
 * min = Integer.MAX_VALUE; int minIndex = Integer.MAX_VALUE;
 *
 * for (int i = start; i <= end; i++) { if (minHopArray[i] < min) { min =
 * minHopArray[i]; minIndex = i; } } return minIndex; }
 */