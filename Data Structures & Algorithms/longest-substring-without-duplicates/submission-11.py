class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        output = 0

        l = 0
        r = 0

        while r < len(s):
            while s[r] in seen:
                seen.remove(s[l])
                l += 1

            seen.add(s[r])
            r += 1
            output = max(output, (r-l))

        return output