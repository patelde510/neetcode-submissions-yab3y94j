class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        tree = defaultdict(list)

        for edge in edges:
            tree[edge[0]].append(edge[1])
            tree[edge[1]].append(edge[0])
        
        visited = set()

        def dfs(node, par):
            if node in visited:
                return False
            
            visited.add(node)
            for nei in tree[node]:
                if nei == par:
                    continue
                if not dfs(nei, node):
                    return False

            return True
        
        return dfs(0, -1) and n == len(visited)
