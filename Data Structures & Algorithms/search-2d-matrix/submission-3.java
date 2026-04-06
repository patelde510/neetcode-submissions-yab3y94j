class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int l = 0;
        int r = numRows * numCols - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / numCols;
            int col = m % numCols;

            if (matrix[row][col] < target) {
                l = m+1;
            } else if (matrix[row][col] > target) {
                r = m-1;
            } else {
                return true;
            }
        }

        return false;
    }
}
