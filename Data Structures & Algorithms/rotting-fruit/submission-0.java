class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int res = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        System.out.println(fresh);

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (fresh > 0 && !q.isEmpty()) {
            int length = q.size();

            for (int i = 0; i < length; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0 || grid[row][col] == 2) {
                        continue;
                    }

                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            res++;
        }

        System.out.println(fresh);

        return fresh == 0 ? res : -1;
    }
}
