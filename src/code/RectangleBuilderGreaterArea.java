package code;

//https://app.codility.com/demo/results/trainingWFCF79-QFF/

import java.util.*;

public class RectangleBuilderGreaterArea {
    public int solution(int[] A, int X) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : A) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }
        int res = 0;
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int a : freq.keySet()) {
            if (freq.get(a) >= 2) {
                sorted.add(a);
            }
        }
        Collections.sort(sorted);

        for (int i = 0; i < sorted.size(); i++) {
            int s = sorted.get(i);
            int other = (int) Math.ceil((double) X / s);

            if (other <= s && freq.get(s) >= 4) {
                res++;
            }
            int sides = countGreaterEqual(sorted, i + 1, other);
            res += sides;
            if (res > 1_000_000_000)
                return -1;
        }
        return res;
    }

    private int countGreaterEqual(List<Integer> sorted, int st, int val) {
        int end = sorted.size() - 1;
        int pos = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int curr = sorted.get(mid);
            if (curr == val) {
                pos = mid;
                break;
            } else if (curr < val) {
                st = mid + 1;
            } else {
                pos = mid;
                end = mid - 1;
            }
        }
        if (pos == -1)
            return 0;
        return sorted.size() - pos;
    }
}
