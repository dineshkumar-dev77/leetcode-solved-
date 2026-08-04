class Solution {

    public int xorAfterQueries(int[] nums, int[][] queries) {

        final long MOD = 1_000_000_007L;

        for (int[] query : queries) {

            int left = query[0];
            int right = query[1];
            int step = query[2];
            long multiplier = query[3];

            for (int idx = left; idx <= right; idx += step) {

                nums[idx] = (int) ((nums[idx] * multiplier) % MOD);
            }
        }

        int answer = 0;

        for (int num : nums) {
            answer ^= num;
        }

        return answer;
    }
}