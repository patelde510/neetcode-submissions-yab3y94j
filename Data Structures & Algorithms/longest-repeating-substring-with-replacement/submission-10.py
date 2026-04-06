class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l = 0
        res = 0
        maxF = 0

        freq = [0] * 26

        for r in range(len(s)):
            freq[ord(s[r]) - ord('A')] += 1
            maxF = max(maxF, freq[ord(s[r]) - ord('A')])

            while ((r - l + 1) - maxF > k):
                freq[ord(s[l]) - ord('A')] -= 1
                l += 1
            
            res = max(res, (r - l + 1))

        
        return res