import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] letters = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, "", result, letters);

        return result;
    }

    private void backtrack(String digits, int index,
                           String current,
                           List<String> result,
                           String[] letters) {

        // If we used every digit
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get current digit
        int digit = digits.charAt(index) - '0';

        // Get letters for that digit
        String possibleLetters = letters[digit];

        // Try every letter
        for (char c : possibleLetters.toCharArray()) {

            backtrack(
                digits,
                index + 1,
                current + c,
                result,
                letters
            );
        }
    }
}