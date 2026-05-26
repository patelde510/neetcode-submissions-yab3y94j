class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        
        # graph = defaultdict(list)

        # for u, v in edges:
        #     graph[u].append(v)
        #     graph[v].append(u)

        # visited = set()
        # res = 0

        # def dfs(v):
        #     visited.add(v)
        #     for n in graph[v]:
        #         if n not in visited:
        #             dfs(n)

        # for v in range(n):
        #     if v not in visited:
        #         res += 1
        #         dfs(v)

        # return res

        graph = defaultdict(list)

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = set()
        res = 0

        def bfs(v):
            q = deque([v])
            visited.add(v)
            while q:
                cur = q.popleft()
                for n in graph[cur]:
                    if n not in visited:
                        visited.add(n)
                        q.append(n)

        for v in range(n):
            if v not in visited:
                res += 1
                bfs(v)

        return res


