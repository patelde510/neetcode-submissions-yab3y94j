class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []

        keyPad = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

        res = []

        combLen = len(digits)
        def dfs(i, cur):
            if i == combLen:
                res.append(cur)
                return

            chars = keyPad[int(digits[i])]
            for char in chars:
                dfs(i+1, cur + char)

            
        dfs(0, "")

        return res