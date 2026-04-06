class Solution {

    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {

        ROWS = board.length;
        COLS = board[0].length;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                // System.out.println(board[row][col]);
                if (dfs(board, row, col, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int row, int col, int i, String word) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            return false;
        }

        if (board[row][col] != word.charAt(i) || board[row][col] == '*') {
            return false;
        }

        board[row][col] = '*';

        boolean res = dfs(board, row-1, col, i+1, word) ||
        dfs(board, row+1, col, i+1, word) ||
        dfs(board, row, col-1, i+1, word) ||
        dfs(board, row, col+1, i+1, word);

        board[row][col] = word.charAt(i);

        return res;

    }
}
