class Solution {

    // private Map<Integer, List<Integer>> preMap;
    // private Set<Integer> visited;
    // private Set<Integer> cycle;
    // private List<Integer> res;

    // public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     preMap = new HashMap<>();
    //     visited = new HashSet<>();
    //     cycle = new HashSet<>();
    //     List<Integer> res = new ArrayList<>();

    //     for (int i = 0; i < numCourses; i++) {
    //         preMap.put(i, new ArrayList<>());
    //     }

    //     for (int[] prereq : prerequisites) {
    //         preMap.get(prereq[0]).add(prereq[1]);
    //     }

    //     for (int c = 0; c < numCourses; c++) {
    //         if (!dfs(c, res)) {
    //             return new int[0];
    //         }
    //     }


        
    //     int[] output = new int[numCourses];
    //     for (int i = 0; i < numCourses; i++) {
    //         output[i] = res.get(i);
    //     }

    //     return output;
    // }

    // private boolean dfs(int courseNum, List<Integer> res) {
    //     if (cycle.contains(courseNum)) {
    //         return false;
    //     }

    //     if (visited.contains(courseNum)) {
    //         return true;
    //     }

    //     cycle.add(courseNum);
    //     for (int course : preMap.getOrDefault(courseNum, Collections.emptyList())) {
    //         if (!dfs(course, res)) {
    //             return false;
    //         }
    //     }

    //     cycle.remove(courseNum);
    //     visited.add(courseNum);
    //     res.add(courseNum);

    //     return true;
    // }


    private Map<Integer, List<Integer>> preMap;
    private Set<Integer> visited;
    private Set<Integer> cycle;
    int i = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        visited = new HashSet<>();
        cycle = new HashSet<>();

        int[] output = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, output)) {
                return new int[0];
            }
        }

        return output;
    }

    private boolean dfs(int courseNum, int[] output) {
        if (cycle.contains(courseNum)) {
            return false;
        }

        if (visited.contains(courseNum)) {
            return true;
        }

        cycle.add(courseNum);
        for (int course : preMap.getOrDefault(courseNum, Collections.emptyList())) {
            if (!dfs(course, output)) {
                return false;
            }
        }

        cycle.remove(courseNum);
        visited.add(courseNum);
        output[i++] = courseNum;

        return true;
    }




}
