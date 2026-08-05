class Solution {

    public boolean canBeEqual(String s1, String s2) {

        // Even positions: 0 and 2
        boolean evenPositions =
                (s1.charAt(0) == s2.charAt(0) &&
                 s1.charAt(2) == s2.charAt(2))
                ||
                (s1.charAt(0) == s2.charAt(2) &&
                 s1.charAt(2) == s2.charAt(0));

        // Odd positions: 1 and 3
        boolean oddPositions =
                (s1.charAt(1) == s2.charAt(1) &&
                 s1.charAt(3) == s2.charAt(3))
                ||
                (s1.charAt(1) == s2.charAt(3) &&
                 s1.charAt(3) == s2.charAt(1));

        return evenPositions && oddPositions;
    }
}