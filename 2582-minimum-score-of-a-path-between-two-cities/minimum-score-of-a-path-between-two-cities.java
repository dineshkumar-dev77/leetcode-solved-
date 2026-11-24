
import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int d = road[2];

            graph[a].add(new int[]{b, d});
            graph[b].add(new int[]{a, d});
        }

        boolean[] visited = new boolean[n + 1];

        return dfs(1, graph, visited, Integer.MAX_VALUE);
    }

    private int dfs(int node, List<int[]>[] graph,
                    boolean[] visited, int ans) {

        visited[node] = true;

        for (int[] edge : graph[node]) {
            int next = edge[0];
            int distance = edge[1];

            ans = Math.min(ans, distance);

            if (!visited[next]) {
                ans = dfs(next, graph, visited, ans);
            }
        }

        return ans;
    }
}
