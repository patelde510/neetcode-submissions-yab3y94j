class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        int i = 0;
        while (true) {
            if (!seen.add(nums[i])) {
                return nums[i];
            }
            i++;
        }
    }
}
