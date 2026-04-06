class Solution {
    private Map<Integer, List<Integer>> graph;

    public int[] findRedundantConnection(int[][] edges) {
        graph = new HashMap<>();

        for (int i = 0; i <= edges.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

            Set<Integer> visited = new HashSet<>();

            if (!(dfs(u, -1, visited))) {
                return edge;
            }
        }

        return new int[0];

    }

    private boolean dfs(int node, int parent, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int n : graph.get(node)) {
            if (n == parent) continue;

            if (!(dfs(n, node, visited))) {
                return false;
            }
        }

        return true;

    }
}

