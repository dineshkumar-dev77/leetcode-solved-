class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean hasOdd = false;
        boolean hasEven = false;

        for (int num : nums1) {
            if (num % 2 == 0)
                hasEven = true;
            else
                hasOdd = true;
        }

        // If all numbers already have the same parity
        if (hasOdd && !hasEven)
            return true;

        if (hasEven && !hasOdd)
            return true;

        // If both odd and even exist, we can make them all odd
        return true;
    }
}