class Solution {
    // Create list of 4 directions
    private int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, COLS-1, atlantic);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, ROWS-1, c, atlantic);
        }

        List<List<Integer>> output = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    output.add(Arrays.asList(r, c));
                }
            }
        }

        return output;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] ocean) {
        ocean[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length && !ocean[newRow][newCol])
            {
                if (heights[newRow][newCol] >= heights[row][col]) {
                    dfs(heights, newRow, newCol, ocean);
                }
            }
        }
    }

        
}
