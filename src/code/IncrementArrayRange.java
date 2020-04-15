package code;

import java.util.TreeSet;

class RangeNode implements Comparable<RangeNode> {
    public int val;
    public int inc = 0;

    RangeNode(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(RangeNode o) {
        return val - o.val;
    }
}

public class IncrementArrayRange {

    public static void main(String[] args) {
        int[][] intervals = {{1, 9, 50}, {2, 9, 2000}, {3, 9, 365},
                {4, 9, 456}, {5, 9, 200000}, {6, 9, 362}, {7, 9, 438},
                {8, 9, 568}, {9, 9, 963}};
        TreeSet<RangeNode> intTree = new TreeSet<>();

        for (int i = 0; i < intervals.length; i++) {
            intTree.add(new RangeNode(intervals[i][0]));
            intTree.add(new RangeNode(intervals[i][1]));
        }

        System.out.println("Search Result");
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            RangeNode startNode = new RangeNode(start);

            RangeNode endNode = intTree.tailSet(startNode).first();
            while (endNode != null && endNode.val <= end) {
                endNode.inc += intervals[i][2];
                endNode = intTree.higher(endNode);
            }

            // intTree.add(new Node(intervals[i][0]));
            // intTree.add(new Node(intervals[i][1]));
        }

        int max = 0;
        for (RangeNode element : intTree) {
            System.out.println(element.val + " " + element.inc);
            max = Math.max(max, element.inc);
        }

        System.out.println(max);
    }
}
