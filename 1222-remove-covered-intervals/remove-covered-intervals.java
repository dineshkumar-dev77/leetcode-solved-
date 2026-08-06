import java.util.Arrays;

class Solution {

    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {

            if (a[0] == b[0]) {
                return b[1] - a[1];   // Descending end
            }

            return a[0] - b[0];       // Ascending start
        });

        int remaining = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {

            if (interval[1] > maxEnd) {

                remaining++;
                maxEnd = interval[1];
            }
        }

        return remaining;
    }
}
