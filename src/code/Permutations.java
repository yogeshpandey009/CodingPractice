package code;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static List<List<Integer>> allPerms = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        String str = "abc";
        printAllPermutations(str, "");
        permute(new int[]{1, 2, 3});
    }

    public static void printAllPermutations(String str, String parent) {
        if (str.length() == 1) {
            System.out.println(parent + str.charAt(0));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            printAllPermutations(
                    str.substring(0, i) + str.substring(i + 1, str.length()),
                    parent + str.charAt(i));
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        findAllPerms(numbers, new ArrayList<Integer>());
        for (List list : allPerms) {
            System.out.println(list);

        }
        return allPerms;
    }

    public static void findAllPerms(List<Integer> input, List<Integer> parent) {
        if (input.size() == 1) {
            parent.add(input.get(0));
            allPerms.add(parent);
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            List<Integer> left = new ArrayList<Integer>(input.subList(0, i));
            // List<Integer> right = new ArrayList<Integer>(input.subList(i+1,
            // input.size()));
            left.addAll(input.subList(i + 1, input.size()));
            List<Integer> next_parent = new ArrayList<Integer>(parent);
            next_parent.add(input.get(i));
            findAllPerms(left, next_parent);
        }
    }

}
