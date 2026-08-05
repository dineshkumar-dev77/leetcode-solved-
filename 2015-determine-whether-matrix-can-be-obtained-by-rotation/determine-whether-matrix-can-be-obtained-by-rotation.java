class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {

        for (int rotation = 0; rotation < 4; rotation++) {

            if (isSame(mat, target)) {
                return true;
            }

            rotate90(mat);
        }

        return false;
    }

    // Rotate matrix 90 degrees clockwise
    private void rotate90(int[][] mat) {

        int n = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Check whether two matrices are equal
    private boolean isSame(int[][] mat, int[][] target) {

        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}