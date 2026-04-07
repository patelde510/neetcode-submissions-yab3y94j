class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = ""
        output = []
        
        def backtrack(o, c):
            nonlocal stack

            if o == c and c == n:
                output.append(stack)
                return
            
            if o < n:
                stack += '('
                backtrack(o+1, c)
                stack = stack[:-1]
                
            if o > c:
                stack += ')'
                backtrack(o, c+1)
                stack = stack[:-1]

        backtrack(0, 0)

        return output