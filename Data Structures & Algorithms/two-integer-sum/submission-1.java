class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> difference = new HashMap<>();

        int[] output = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (difference.containsKey(diff)) {
                output[0] = difference.get(diff);
                output[1] = i;
            } else {
                difference.put(nums[i], i);
            }
        }

        return output;
    }
}
