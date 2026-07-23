class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""

        for s in strs:
            res += str(len(s)) + "#" + s

        return res
    # 5#Hello
    def decode(self, s: str) -> List[str]:
        res = []

        l = 0

        while l < len(s):
            r = l
            while s[r] != "#":
                r += 1
            length = int(s[l:r])
            l = r + 1
            r += length+1
            res.append(s[l:r])

            l = r
        
        return res
