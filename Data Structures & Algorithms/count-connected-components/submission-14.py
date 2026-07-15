class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        visited = set()
        res = 0

        graph = defaultdict(list)

        for u, v, in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        def dfs(node):
            if node in visited:
                return
            visited.add(node)
            for v in graph[node]:
                dfs(v)
        
        for v in range(n):
            if v not in visited:
                dfs(v)
                res += 1

        return res