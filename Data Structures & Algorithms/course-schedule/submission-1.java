class Solution {
    private Map<Integer, List<Integer>> preMap;
    private Set<Integer> visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!(dfs(i))) {
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int courseNum) {
        if (visited.contains(courseNum)) {
            return false;
        }

        if (preMap.get(courseNum).isEmpty()) {
            return true;
        }

        visited.add(courseNum);

        for (int course : preMap.get(courseNum)) {
            if (!(dfs(course))) {
                return false;
            }
        }

        // preMap.put(courseNum, new ArrayList<>());
        visited.remove(courseNum);

        return true;

    }

}
