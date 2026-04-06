class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];

        backtrack(nums, cur, pick);

        return res;
    }

    private void backtrack(int[] nums, List<Integer> cur, boolean[] pick) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                cur.add(nums[i]);
                pick[i] = true;
                backtrack(nums, cur, pick);
                cur.remove(cur.size() - 1);
                pick[i] = false;
            }
        }
    }
}
