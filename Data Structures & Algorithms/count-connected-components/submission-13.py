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

            for i in graph[node]:
                dfs(i)
        
        for node in range(n):
            if node not in visited:
                dfs(node)
                res += 1

        return res