class Solution {

    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;

    public int countComponents(int n, int[][] edges) {

        graph = new HashMap<>();
        visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        for (int node = 0; node < n; node++) {
            if (!(visited.contains(node))) {
                dfs(node, -1);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, int parent) {
        visited.add(node);
        for (int n : graph.get(node)) {
            if (!visited.contains(n)) {
               dfs(n, node); 
            }
        }
    }
}
