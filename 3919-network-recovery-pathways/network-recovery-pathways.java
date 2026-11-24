
import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        int high = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            high = Math.max(high, e[2]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] e : graph[u]) {
                int v = e[0];
                indegree[v]--;

                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int low = 0, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;

            for (int u : topo) {
                if (dist[u] == Long.MAX_VALUE) continue;

                for (int[] e : graph[u]) {
                    int v = e[0];
                    int cost = e[1];

                    if (cost < mid) continue;
                    if (!online[v] && v != n - 1) continue;

                    long nd = dist[u] + cost;

                    if (nd < dist[v]) {
                        dist[v] = nd;
                    }
                }
            }

            if (dist[n - 1] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
