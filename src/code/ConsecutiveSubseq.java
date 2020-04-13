package code;

import java.util.TreeMap;

public class ConsecutiveSubseq {
    public static void main(String[] args) {
        ConsecutiveSubseq c = new ConsecutiveSubseq();
        System.out.println(c.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
    }

    public boolean isPossible(int[] nums) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int a : nums) {
            freqMap.put(a, freqMap.getOrDefault(a, 0) + 1);
        }
        int len = 0;
        int curr = 0;
        while (freqMap.size() > 0) {
            if (len == 0)
                curr = freqMap.firstKey();
            Integer freq = freqMap.getOrDefault(curr, 0);
            if (freq == 0) {
                if (len >= 3)
                    len = 0;
                else
                    return false;
            } else if (freq > 1) {
                Integer nextFreq = freqMap.getOrDefault(curr + 1, 0);
                Integer nextNextFreq = freqMap.getOrDefault(curr + 2, 0);
                if (nextFreq > 1 && nextNextFreq > 1) {
                    freqMap.put(curr, freq - 1);
                    freqMap.put(curr + 1, nextFreq - 1);
                    freqMap.put(curr + 2, nextNextFreq - 1);
                    len += 3;
                    curr = curr + 3;
                } else if (len <= 2) {
                    freqMap.put(curr, freq - 1);
                    len++;
                    curr = curr + 1;
                } else if (len >= 3) {
                    len = 0;
                }
            } else if (freq == 1) {
                freqMap.remove(curr);
                len++;
                curr = curr + 1;
            }
        }
        return len == 0 || len >= 3;
    }
}