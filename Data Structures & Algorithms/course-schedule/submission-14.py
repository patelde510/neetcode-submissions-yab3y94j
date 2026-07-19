class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)

        for crs, pre in prerequisites:
            graph[crs].append(pre)
        
        visited = set()

        def isCycle(crs):
            if crs in visited:
                return True
            
            visited.add(crs)

            for pre in graph[crs]:
                if isCycle(pre):
                    return True

            visited.remove(crs)

            return False
        
        for c in range(numCourses):
            if isCycle(c):
                return False

        return True