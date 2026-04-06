class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    
    public boolean validTree(int n, int[][] edges) {

        adj = new HashMap<>();
        visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if (!dfs(0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for (int n : adj.get(node)) {

            if (n == parent) continue;

            if (!dfs(n, node)) {
                return false;
            }
        }

        return true;
    }
}
