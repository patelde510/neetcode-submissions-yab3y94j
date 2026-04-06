class Solution {

    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        boolean res = false;

        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
            if (board[r][c] == word.charAt(i) && board[r][c] != '#') {
                board[r][c] = '#';

                res = dfs(board, word, r-1, c, i+1) ||
                dfs(board, word, r, c+1, i+1) ||
                dfs(board, word, r+1, c, i+1) ||
                dfs(board, word, r, c-1, i+1);

                board[r][c] = word.charAt(i);
            }
        }

        return res;

    }
}
