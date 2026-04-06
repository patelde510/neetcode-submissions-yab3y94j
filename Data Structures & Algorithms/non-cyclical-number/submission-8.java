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
            System.out.println(n);
            num += Math.pow((n % 10), 2);
            n /= 10;
        }
        System.out.println("This is num: " + num);

        return isHappy(num);
    }
}
