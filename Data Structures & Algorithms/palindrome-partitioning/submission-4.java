class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        dfs(s, cur, 0);
        
        return res;
    }

    private void dfs(String s, List<String> cur, int i) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int size = 1; size <= s.length(); size++) {
            if (isPalindrome(s.substring(0, size))) {
                cur.add(s.substring(0, size));
                dfs(s.substring(size), cur, i+size);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
