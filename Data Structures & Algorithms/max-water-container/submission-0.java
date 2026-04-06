class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int output = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);

            output = Math.max(output, area);

            if (heights[l] > heights[r]) {
                r--;
            } else if (heights[r] > heights[l]) {
                l++;
            } else {
                r--;
                l++;
            }
        }

        return output;
    }
}
