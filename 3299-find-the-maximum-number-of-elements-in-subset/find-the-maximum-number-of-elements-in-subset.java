import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        for (long x : map.keySet()) {

            if (x == 1) {
                int count = map.get(x);
                ans = Math.max(ans, count % 2 == 0 ? count - 1 : count);
                continue;
            }

            int len = 0;

            while (map.getOrDefault(x, 0) >= 2) {

                len += 2;
                x = x * x;
            }

            if (map.getOrDefault(x, 0) >= 1) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}