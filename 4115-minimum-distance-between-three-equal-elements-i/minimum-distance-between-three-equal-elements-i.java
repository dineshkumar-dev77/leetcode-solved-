import java.util.*;

class Solution {

    public int minimumDistance(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int answer = Integer.MAX_VALUE;

        for (List<Integer> indices : map.values()) {

            if (indices.size() < 3) {
                continue;
            }

            for (int i = 0; i <= indices.size() - 3; i++) {

                int first = indices.get(i);
                int third = indices.get(i + 2);

                int distance = 2 * (third - first);

                answer = Math.min(answer, distance);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}