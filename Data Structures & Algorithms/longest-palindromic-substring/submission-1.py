class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        resLen = 0

        # def checkOut()

        for c in range(len(s)):
            # Odd Length
            l, r = c, c
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if r-l+1 > resLen:
                    res = s[l:r+1]
                    resLen = r-l+1
                l -= 1
                r += 1

            # Even Length
            l, r = c, c+1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                if r-l+1 > resLen:
                    res = s[l:r+1]
                    resLen = r-l+1
                l -= 1
                r += 1

        return res
