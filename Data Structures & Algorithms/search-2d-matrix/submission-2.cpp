class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int ROW = matrix.size();
        int COL = matrix[0].size();

        int l = 0;
        int r = ROW * COL - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            std::cout << m;
            int row = m / COL;
            int col = m % COL;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }
};
