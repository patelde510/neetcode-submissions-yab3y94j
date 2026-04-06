class Solution {

    private int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };
    
    boolean pacific;
    boolean atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                pacific = false;
                atlantic = false;
                dfs(heights, r, c, Integer.MAX_VALUE);
                if (pacific && atlantic) {
                    // List<Integer> cur = new ArrayList<>();
                    // cur.add(r);
                    // cur.add(c);
                    // res.add(cur);
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevVal) {
        if (r < 0 || c < 0) {
            pacific = true;
            return;
        }

        if (r >= heights.length || c >= heights[0].length) {
            atlantic = true;
            return;
        }

        if (heights[r][c] > prevVal) {
            return;
        }

        int temp = heights[r][c];
        heights[r][c] = Integer.MAX_VALUE;

        for (int[] dir : directions) {
            int row = r + dir[0];
            int col = c + dir[1];
            
            dfs(heights, row, col, temp);
            if (pacific && atlantic) {
                break;
            } 
        }
        heights[r][c] = temp;
    }
}
