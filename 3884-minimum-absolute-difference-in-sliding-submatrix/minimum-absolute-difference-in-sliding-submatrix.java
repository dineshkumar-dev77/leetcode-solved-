import java.util.*;

class Solution {

    public int[][] minAbsDiff(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int r = 0; r <= m - k; r++) {

            for (int c = 0; c <= n - k; c++) {

                TreeSet<Integer> set = new TreeSet<>();

                // Add all elements of the k x k submatrix
                for (int i = r; i < r + k; i++) {

                    for (int j = c; j < c + k; j++) {
                        set.add(grid[i][j]);
                    }
                }

                // Only one distinct value
                if (set.size() <= 1) {
                    ans[r][c] = 0;
                    continue;
                }

                int minDiff = Integer.MAX_VALUE;

                Integer previous = null;

                // Since TreeSet is sorted,
                // minimum difference will be between adjacent values.
                for (int value : set) {

                    if (previous != null) {
                        minDiff = Math.min(
                            minDiff,
                            value - previous
                        );
                    }

                    previous = value;
                }

                ans[r][c] = minDiff;
            }
        }

        return ans;
    }
}