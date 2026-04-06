class Solution {
    boolean[][] seen;
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        int wordLen = word.length();

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                // if (board[r][c] == word.charAt(0)) {
                seen = new boolean[h][w];
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
                // }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
            if (board[r][c] == word.charAt(i) && !seen[r][c]) {
                seen[r][c] = true;
                return dfs(board, word, r-1, c, i+1) ||
                dfs(board, word, r, c+1, i+1) ||
                dfs(board, word, r+1, c, i+1) ||
                dfs(board, word, r, c-1, i+1);
            }
        }

        return false;

    }
}
