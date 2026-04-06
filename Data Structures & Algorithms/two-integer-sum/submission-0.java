class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> difference = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (difference.containsKey(diff)) {
                return new int[]{difference.get(diff), i};
            } else {
                difference.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
