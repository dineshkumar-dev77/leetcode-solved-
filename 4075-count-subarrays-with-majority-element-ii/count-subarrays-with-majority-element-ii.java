
class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] bit = new int[2 * n + 3];

        int prefix = 0;
        long ans = 0;

        // Insert initial prefix sum 0
        update(bit, n + 1);

        for (int num : nums) {
            if (num == target) {
                prefix++;
            } else {
                prefix--;
            }

            int index = prefix + n + 1;

            // Count previous prefix sums smaller than current
            ans += query(bit, index - 1);

            update(bit, index);
        }

        return ans;
    }

    void update(int[] bit, int i) {
        while (i < bit.length) {
            bit[i]++;
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
