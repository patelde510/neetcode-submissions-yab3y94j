class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        
        q = deque([0])
        seen = [False] * (amount + 1)
        seen[0] = True
        res = 0

        while q:
            res += 1
            for _ in range(len(q)):
                cur = q.popleft()
                for coin in coins:
                    newV = coin + cur
                    if newV == amount:
                        return res
                    if newV > amount or seen[newV]:
                        continue
                    seen[newV] = True
                    q.append(newV)

        return -1