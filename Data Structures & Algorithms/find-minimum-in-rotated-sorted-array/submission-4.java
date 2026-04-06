class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int output = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                output = Math.min(output, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;
            output = Math.min(output, nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return output;
    }
}
