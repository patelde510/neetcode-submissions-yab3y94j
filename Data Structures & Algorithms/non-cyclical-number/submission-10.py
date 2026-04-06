class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        num = 0

        while n != 1:
            if n in seen:
                return False
            seen.add(n)
            num = 0
            print(str(n))
            for digit in str(n):
                print(digit)
                num += int(digit) ** 2
            
            n = int(num)
        
        return True