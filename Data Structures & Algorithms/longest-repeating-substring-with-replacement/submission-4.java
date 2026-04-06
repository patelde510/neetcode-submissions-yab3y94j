class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int res = 0;
        int maxf = 0;

        int[] freq = new int[26];

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, freq[s.charAt(r) - 'A']);

            if ((r - l + 1) - maxf > k) {
                while ((r - l + 1) - maxf > k) {
                    freq[s.charAt(l) - 'A']--;
                    l++;
                }
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
