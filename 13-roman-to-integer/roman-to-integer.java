import java.util.HashMap;

class Solution {

    public int romanToInt(String s) {

        HashMap<Character, Integer> values = new HashMap<>();

        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = values.get(s.charAt(i));

            // Check if there is a next character
            if (i + 1 < s.length()) {

                int next = values.get(s.charAt(i + 1));

                if (current < next) {
                    result -= current;
                } else {
                    result += current;
                }

            } else {
                // Last character is always added
                result += current;
            }
        }

        return result;
    }
}