import java.util.*;

class Solution {

    public int[] arrayRankTransform(int[] arr) {

        int[] sorted = arr.clone();

        Arrays.sort(sorted);

        HashMap<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {

            // Give rank only to a new value
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Replace each original value with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}