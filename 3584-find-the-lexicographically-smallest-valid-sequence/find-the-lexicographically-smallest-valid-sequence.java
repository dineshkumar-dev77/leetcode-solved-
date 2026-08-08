import java.util.*;

class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

    

        int[][] next = new int[26][n + 1];

        for (int c = 0; c < 26; c++) {
            next[c][n] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int c = 0; c < 26; c++) {
                next[c][i] = next[c][i + 1];
            }

            next[word1.charAt(i) - 'a'][i] = i;
        }

       

        int[] exact = new int[m + 1];

        exact[m] = n;

        int pos = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (pos >= 0 &&
                   word1.charAt(pos) != word2.charAt(j)) {
                pos--;
            }

            if (pos < 0) {
                exact[j] = -1;
            } else {
                exact[j] = pos;
                pos--;
            }
        }

        
        int[] answer = new int[m];

        int current = 0;
        boolean changed = false;

        for (int j = 0; j < m; j++) {

            char target = word2.charAt(j);

            int chosen = -1;

           
            for (int i = current; i < n; i++) {

                boolean same = word1.charAt(i) == target;

                if (same) {
                    chosen = i;
                    break;
                }

                if (!changed) {

                   
                    int remaining = j + 1;

                    if (remaining == m) {
                        chosen = i;
                        changed = true;
                        break;
                    }

                    if (exact[remaining] > i) {
                        chosen = i;
                        changed = true;
                        break;
                    }
                }
            }

            if (chosen == -1) {
                return new int[0];
            }

            if (word1.charAt(chosen) != target) {
                changed = true;
            }

            answer[j] = chosen;
            current = chosen + 1;
        }

        return answer;
    }
}