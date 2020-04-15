package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwitterRecommender {

    public static List<Integer> recommendation(int[][] follows_graph,
                                               int[][] likes_graph, int user, int min_threashhold) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> follows = new HashSet<>();
        for (int i = 0; i < follows_graph.length; i++) {
            if (follows_graph[i][0] == user) {
                follows.add(follows_graph[i][1]);
            }
        }
        Map<Integer, Integer> likedTweetsMap = new HashMap<>();
        for (int i = 0; i < likes_graph.length; i++) {
            if (follows.contains(likes_graph[i][0])) {
                int tweetId = likes_graph[i][1];
                if (likedTweetsMap.containsKey(tweetId)) {
                    likedTweetsMap
                            .put(tweetId, likedTweetsMap.get(tweetId) + 1);
                } else {
                    likedTweetsMap.put(tweetId, 1);
                }
            }
        }

        for (Integer tweets : likedTweetsMap.keySet()) {
            if (likedTweetsMap.get(tweets) >= min_threashhold) {
                result.add(tweets);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] follows = new int[][]{{1, 2}, {2, 3}, {3, 1}, {1, 3}};
        int[][] likes = new int[][]{{1, 2}, {2, 3}, {3, 3}, {1, 1},
                {3, 2}};
        List<Integer> sol = recommendation(follows, likes, 1, 2);
        System.out.println(sol.toString());
    }

}
