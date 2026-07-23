class Solution:
    def isValid(self, s: str) -> bool:
        closeToOpen = {
            ")": "(",
            "}": "{",
            "]": "["
        }

        stack = []

        for c in s:
            if c in closeToOpen and stack:
                if closeToOpen[c] == stack[-1]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        
        return True if not stack else False

