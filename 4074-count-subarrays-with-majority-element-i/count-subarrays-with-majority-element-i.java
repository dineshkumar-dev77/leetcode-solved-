class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;
        int offset = n + 1;

        int[] bit = new int[2 * n + 3];

        int ans = 0;
        int sum = 0;

        update(bit, offset, 1);

        for (int num : nums) {

            if (num == target)
                sum++;
            else
                sum--;

            ans += query(bit, offset + sum - 1);

            update(bit, offset + sum, 1);
        }

        return ans;
    }

    void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i;
        }
    }

    int query(int[] bit, int i) {
        int sum = 0;

        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }

        return sum;
    }
}