class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] output = new int[k];

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(freq.values());
        Collections.sort(values, Collections.reverseOrder());

        System.out.println(freq);
        System.out.println(values);

        int i = 0;
        while (i < k) {
            for (int key : freq.keySet()) {
                if (freq.get(key) == values.get(i)) {
                    output[i] = key;
                    freq.remove(key);
                    break;
                }
            }
            i++;
        }
        

        return output;
    }
}
