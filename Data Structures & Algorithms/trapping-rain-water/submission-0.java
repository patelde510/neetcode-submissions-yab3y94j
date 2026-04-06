class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n-1;
        int maxLeft = height[l];
        int maxRight = height[r];

        int output = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                output += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                output += maxRight - height[r];
            }
        }

        return output;
    }
}
