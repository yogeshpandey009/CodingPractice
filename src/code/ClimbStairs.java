package code;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    Map<Integer, Integer> dp = new HashMap<Integer, Integer>() {
        {
            put(1, 1);
            put(2, 2);
        }
    };

    public int climbStairs(int n) {
        Integer steps = dp.get(n);
        if (steps != null)
            return steps;
        else {
            steps = climbStairs(n - 1) + climbStairs(n - 2);
        }
        dp.put(n, steps);
        return steps;
    }

    public int climbStairsIter(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        int oneStepWays = 2;
        int twoStepWays = 1;
        int x = 0;
        for (int i = 3; i <= n; i++) {
            x = oneStepWays + twoStepWays;
            twoStepWays = oneStepWays;
            oneStepWays = x;
        }
        return x;
    }

}
