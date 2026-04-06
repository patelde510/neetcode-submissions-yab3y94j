class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)

        for crs, pre in prerequisites:
            graph[crs].append(pre)

        visited = set()

        def isCycle(crs):
            if crs in visited:
                return True
            
            # No prereqs or already validated
            if graph[crs] == []:
                return False
            
            visited.add(crs)

            for pre in graph[crs]:
                if isCycle(pre):
                    return True
            
            visited.remove(crs)
            graph[crs] = []

            return False

        for i in range(numCourses):
            if isCycle(i):
                return False

        return True
