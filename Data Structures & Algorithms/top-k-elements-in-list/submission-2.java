class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[n + 1];
        int[] output = new int[k];

        for (int i = 0; i < n+1; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = n; i > 0 && index < k; i--) {
            for (int val : freq[i]) {
                output[index++] = val;
                if (index == k) break;
            }
        }
        
        return output;
    }
}
