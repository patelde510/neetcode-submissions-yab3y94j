class Solution {
    Set<Integer> seen = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (seen.contains(n)) {
            return false;
        }
        seen.add(n);

        int num = 0;

        while (n != 0) {
            num += Math.pow((n % 10), 2);
            n /= 10;
        }

        return isHappy(num);
    }
}
