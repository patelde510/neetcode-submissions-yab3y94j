class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int result = max;
        int l = 0;
        int r = max-1;

        while (l <= r) {
            int m = (l + r) / 2;

            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double )pile / m);
            }
            
            if (hours <= h) {
                result = Math.min(result, m);
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return result;
    }
}
