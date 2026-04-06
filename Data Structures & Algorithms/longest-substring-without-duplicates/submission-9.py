class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()

        res = 0

        left = 0
        right = 0

        while right < len(s):
            while s[right] in seen:
                seen.remove(s[left])
                left += 1

            seen.add(s[right])
            right += 1
            res = max(res, right-left)

        return res