
import java.util.*;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int mod = 1000000007;

        int[][] dp = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        dp[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X') {
                    continue;
                }

                if (i == n - 1 && j == n - 1) {
                    continue;
                }

                int best = -1;
                int count = 0;

                int[][] dir = {
                    {1, 0},
                    {0, 1},
                    {1, 1}
                };

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < n && nj < n && dp[ni][nj] != -1) {

                        if (dp[ni][nj] > best) {
                            best = dp[ni][nj];
                            count = ways[ni][nj];
                        }
                        else if (dp[ni][nj] == best) {
                            count = (count + ways[ni][nj]) % mod;
                        }
                    }
                }

                if (best == -1) {
                    continue;
                }

                char ch = board.get(i).charAt(j);

                int value = (ch == 'E' || ch == 'S')
                            ? 0 : ch - '0';

                dp[i][j] = best + value;
                ways[i][j] = count;
            }
        }

        if (dp[0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{dp[0][0], ways[0][0]};
    }
}
