class Solution {
    Map<Integer, Integer> count;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        count = new HashMap<>();
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        List<Integer> A = new ArrayList<>();

        for (int num : nums) {
            if (!count.containsKey(num)) {
                A.add(num);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        

        backtrack(A, target, 0, cur);

        return res;
    }

    private void backtrack(List<Integer> nums, int target, int i, List<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || i >= nums.size()) {
            return;
        }

        if (count.get(nums.get(i)) > 0) {
            cur.add(nums.get(i));
            count.put(nums.get(i), count.get(nums.get(i)) - 1);
            
            backtrack(nums, target - nums.get(i), i, cur);

            cur.remove(cur.size()-1);
            count.put(nums.get(i), count.get(nums.get(i)) + 1);
            
        }
        backtrack(nums, target, i+1, cur);
    }
}
