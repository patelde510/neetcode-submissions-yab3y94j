class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if (n2 > n1) return "";

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int have = 0;
        int need = tCount.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int r = 0; r < n1; r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && window.get(c).equals(tCount.get(c))) {
                have++;
            }

            while (have == need) {
                char leftC = s.charAt(l);
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r + 1;
                }

                window.put(leftC, window.get(leftC) - 1);

                if (tCount.containsKey(leftC) && window.get(leftC) < tCount.get(leftC)) {
                    have--;
                }
                
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]);
    }
}
