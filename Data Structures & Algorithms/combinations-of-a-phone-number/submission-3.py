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
            
            for j in range(len(keyPad[int(digits[i])])):
                dfs(i+1, cur + keyPad[int(digits[i])][j])

            
        dfs(0, "")

        return res