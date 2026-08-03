class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * (n+1)
        dp[n] = True

        for l in range(n-1, -1, -1):
            for word in wordDict:
                r = l + len(word)
                if r <= n and s[l:r] == word and dp[r]:
                    dp[l] = True
                    break

        return dp[0]