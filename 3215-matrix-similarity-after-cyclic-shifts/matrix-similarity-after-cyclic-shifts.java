class Solution {

    public boolean areSimilar(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;

        k = k % cols;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int expectedIndex;

                if (i % 2 == 0) {
                    // Even row: shifted LEFT
                    expectedIndex = (j + k) % cols;
                } else {
                    // Odd row: shifted RIGHT
                    expectedIndex = (j - k + cols) % cols;
                }

                if (mat[i][j] != mat[i][expectedIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}