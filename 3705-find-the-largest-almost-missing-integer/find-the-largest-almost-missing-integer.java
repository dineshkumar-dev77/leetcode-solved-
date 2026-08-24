import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        // Generate every subarray of size k
        for (int i = 0; i <= nums.length - k; i++) {

            Set<Integer> seen = new HashSet<>();

            // Take the current subarray
            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            // Count this subarray once for each distinct number
            for (int num : seen) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        // Find the largest number appearing in exactly one subarray
        int answer = -1;

        for (int num : count.keySet()) {
            if (count.get(num) == 1) {
                answer = Math.max(answer, num);
            }
        }

        return answer;
    }
}