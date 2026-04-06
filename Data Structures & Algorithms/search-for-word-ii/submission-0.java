class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int indx = -1;
    int refs = 0;
}

class Solution {

    List<String> res;
    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        root = new TrieNode();

        populateTrie(root, words);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, words);
            }
        }
        

        return res;
    }

    private void populateTrie(TrieNode root, String[] words) {
        int indx = 0;
        for (String word : words) {
            TrieNode cur = root;
            cur.refs++;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
                cur.refs++;
            }
            cur.indx = indx++;
        }
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String[] words) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
        board[r][c] == '#' || node.children[board[r][c] - 'a'] == null) {
            return;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        TrieNode prev = node;
        node = node.children[temp - 'a'];
        if (node.indx != -1) {
            res.add(words[node.indx]);
            node.indx = -1;
            node.refs--;
            if (node.refs == 0) {
                node = null;
                prev.children[temp - 'a'] = null;
                board[r][c] = temp;
                return;
            }
        }

        dfs(board, r + 1, c, node, words);
        dfs(board, r - 1, c, node, words);
        dfs(board, r, c + 1, node, words);
        dfs(board, r, c - 1, node, words);

        board[r][c] = temp;
    }
}
