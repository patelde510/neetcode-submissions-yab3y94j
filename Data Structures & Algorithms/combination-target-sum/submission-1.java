class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(nums, 0, target, cur);

        return res;
    }

    private void backtrack(int[] nums, int i, int target, List<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, i, target - nums[i], cur);
        cur.remove(cur.size() - 1);
        backtrack(nums, i+1, target, cur);

    }
}
