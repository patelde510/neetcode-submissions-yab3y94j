class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        indegree = [0] * numCourses

        for crs, pre in prerequisites:
            graph[crs].append(pre)
            indegree[pre] += 1
        
        q = deque()

        for i in range(len(indegree)):
            if indegree[i] == 0:
                q.append(i)

        ordering = []

        while q:
            cur = q.popleft()
            ordering.append(cur)

            for pre in graph[cur]:
                indegree[pre] -= 1

                if indegree[pre] == 0:
                    q.append(pre)
        
        if len(ordering) != numCourses:
            return False

        return True