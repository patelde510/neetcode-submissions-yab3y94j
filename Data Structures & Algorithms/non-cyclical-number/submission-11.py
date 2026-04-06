class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()

        while n not in seen:
            seen.add(n)
            n = self.sumOfSquare(n)
            if n == 1:
                return True
        
        return False

    def sumOfSquare(self, n):
        total = 0
        while n:
            total += (n % 10) ** 2
            n = n // 10
        return total
