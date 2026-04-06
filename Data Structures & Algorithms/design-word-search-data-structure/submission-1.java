class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int i, TrieNode root) {
        TrieNode cur = root;

        for (int j = i; j < word.length(); j++) {
            if (word.charAt(j) != '.') {
                int index = word.charAt(j) - 'a';
                if (cur.children[index] == null) {
                    return false;
                } else {
                    cur = cur.children[index];
                }
            } else {
                for (TrieNode node : cur.children) {
                    if (node != null && dfs(word, j + 1, node)) {
                        return true;
                    }
                }
                return false;
            }
            
        }

        return cur.isEnd;
    }
}
