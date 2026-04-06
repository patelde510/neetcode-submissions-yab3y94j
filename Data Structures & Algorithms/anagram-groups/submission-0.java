class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();

        int n = strs.length;
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            List<String> sub = new ArrayList<>();

            for (int j = i; j < n; j++) {
                if (!seen[j] && isAnagram(strs[i], strs[j])) {
                    sub.add(strs[j]);
                    seen[j] = true;
                }
            }

            if (sub.size() != 0) {
                output.add(sub);
            }
            
        }

        return output;
    }

    public boolean isAnagram(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int num : freq) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
