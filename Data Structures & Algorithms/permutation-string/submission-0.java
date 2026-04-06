class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n2 < n1) {
            return false;
        }

        for (int i = 0; i <= n2 - n1; i++) {
            boolean curForm = true;
            int[] freq = new int[26];
            for (char c : s2.substring(i, i+n1).toCharArray()) {
                freq[c - 'a']++;
            }
            for (char c : s1.toCharArray()) {
                freq[c - 'a']--;
            }

            for (int num : freq) {
                if (num != 0) {
                    curForm = false;
                }
            }

            if (!curForm) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }
}
