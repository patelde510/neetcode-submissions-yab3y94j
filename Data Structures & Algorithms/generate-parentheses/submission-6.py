class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        output = []
        
        def backtrack(o, c):
            nonlocal stack

            if o == c and c == n:
                output.append("".join(stack))
                return
            
            if o < n:
                stack.append('(')
                backtrack(o+1, c)
                stack.pop()
                
            if o > c:
                stack.append(')')
                backtrack(o, c+1)
                stack.pop()

        backtrack(0, 0)

        return output