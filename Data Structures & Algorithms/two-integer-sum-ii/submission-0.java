class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] output = new int[2];
        int n = numbers.length;
        loop1: for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    output[0] = i+1;
                    output[1] = j+1;
                    break loop1;
                }
            }
        }

        return output;
    }
}
