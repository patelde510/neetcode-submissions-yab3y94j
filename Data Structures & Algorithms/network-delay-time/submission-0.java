class Solution {

    Map<Integer, List<int[]>> adj = new HashMap<>();
    Map<Integer, Integer> dist = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        for (int i = 1; i <= n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }

        dfs(k, 0);

        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int node, int time) {
        if (time >= dist.get(node)) return;

        dist.put(node, time);

        if (!adj.containsKey(node)) return;

        for (int[] edge : adj.get(node)) {
            dfs(edge[0], time + edge[1]);
        }
    }
}
