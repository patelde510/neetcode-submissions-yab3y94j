class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, cur, 0);

        return res;
        
    }

    private void backtrack(int[] nums, List<Integer> cur, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, cur, i+1);
        
        while (i < nums.length-1 && nums[i] == nums[i+1]) {
            i++;
        }
        cur.remove(cur.size() - 1);
        backtrack(nums, cur, i+1);
    }
}
