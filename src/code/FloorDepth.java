package code;

import java.util.Stack;

//https://app.codility.com/demo/results/trainingS43RAJ-88N/

public class FloorDepth {
    public int solution(int[] A) {
        int prevMax = 0;
        int prevVal = 0;
        int maxDiff = 0;
        for (int a : A) {
            if (a == prevVal) continue;
            if (a < prevVal) {
                prevVal = a;
                prevMax = Math.max(prevMax, a);
            } else {
                if (a < prevMax) {
                    maxDiff = Math.max(maxDiff, a - prevVal);
                } else {
                    maxDiff = Math.max(maxDiff, prevMax - prevVal);
                    prevMax = a;
                    prevVal = a;
                }
            }
        }
        return maxDiff;
    }
    /*
    public int solution(int[] A) {
        Stack<Integer[]> st = new Stack<>();
        st.push(new Integer[] {0, 0});
        int maxDiff = 0;
        for(int a: A) {
            Integer[] top = st.peek();
            if (a == top[0]) continue;
            if (a < top[0]) {
                st.push(new Integer[] {a, top[1]});
            } else {
                if (a < top[1]) {
                    maxDiff = Math.max(maxDiff, a - top[0]);
                } else {
                    maxDiff = Math.max(maxDiff, top[1] - top[0]);
                    while(a >= top[0] && !st.isEmpty()) {
                        top = st.pop();
                    }
                    st.push(new Integer[] {a, a});
                }
            }
        }
        return maxDiff;
    }
    */
}