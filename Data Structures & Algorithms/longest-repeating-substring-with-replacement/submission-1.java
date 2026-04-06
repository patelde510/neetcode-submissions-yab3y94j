class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int res = 0;

        // Map<Character, Integer> count = new HasMap<>();
        int[] freq = new int[26];

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;

            if ((r - l + 1) - freq[getMax(freq)] <= k) {
                res = Math.max(res, r - l + 1);
            } else {
                while ((r - l + 1) - freq[getMax(freq)] > k) {
                    freq[s.charAt(l) - 'A']--;
                    l++;
                }
            }

        }

        return res;
    }

    // public char getMax(Map<Character, Integer> count) {
        
    // }
    public int getMax(int[] freq) {
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxVal) {
                maxVal = freq[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
