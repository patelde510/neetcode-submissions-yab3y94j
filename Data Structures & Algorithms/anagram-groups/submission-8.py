class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        subLists = defaultdict(list)
        res = []

        for s in strs:
            freq = [0] * 26

            for c in s:
                freq[ord(c) - ord('a')] += 1
            
            subLists[tuple(freq)].append(s)
        
        for lst in subLists.values():
            res.append(lst)
        
        return res

