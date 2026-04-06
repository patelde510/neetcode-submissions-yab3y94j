class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        visited = set()
        graph = defaultdict(list)

        def dfs(vert: int):
            visited.add(vert)
            for n in graph[vert]:
                if n not in visited:
                    dfs(n)

        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        
        total = 0

        for vert in range(n):
            if vert not in visited:
                dfs(vert)
                total += 1

        return total