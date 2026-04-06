class Solution {

    private int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pac);
            dfs(heights, rows-1, c, atl);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pac);
            dfs(heights, r, cols-1, atl);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;
        for (int[] dir : directions) {
            int row = r + dir[0];
            int col = c + dir[1];
            if (row >= 0 && col >= 0 && row < heights.length && col < heights[0].length &&
                !ocean[row][col] && heights[row][col] >= heights[r][c]) {
                dfs(heights, row, col, ocean);
            }
        }
    }
}
