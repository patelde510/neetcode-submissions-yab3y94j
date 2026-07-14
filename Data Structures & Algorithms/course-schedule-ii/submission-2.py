class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list)

        for crs, pre in prerequisites:
            graph[crs].append(pre)

        res = []
        visited, cycle = set(), set()

        def dfs(crs):
            if crs in cycle:
                return False
            if crs in visited:
                return True

            cycle.add(crs)

            for pre in graph[crs]:
                if not dfs(pre):
                    return False

            cycle.remove(crs)            
            visited.add(crs)
            res.append(crs)

            return True

        for c in range(numCourses):
            if not dfs(c):
                return []
        
        return res