import java.util.HashSet;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);

            // Remove characters until current becomes unique.
            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(current);

            int currentLength = right - left + 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}