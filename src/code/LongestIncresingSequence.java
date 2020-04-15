package code;

class LongestIncresingSequence {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = 1, start = 0, end = 0, max_pos = 0, prev = 0;
        while (end < A.length) {
            // System.out.println("start" + start);
            // System.out.println("end" + end);
            if (start == end)
                end++;
            else if (A[end - 1] < A[end]) {
                end++;
            } else if (A[end - 1] >= A[end]) {
                start = end;
            }
            if (end - start > max) {
                max = end - start;
                max_pos = start;
            }

        }
        return max_pos;
    }

    public static void main(String[] args) {
        System.out
                .println(solution(new int[]{10, 22, 9, 33, 21, 50, 41, 60}));
        // 10, 22, 9, 33, 21, 50, 41, 60
    }
}