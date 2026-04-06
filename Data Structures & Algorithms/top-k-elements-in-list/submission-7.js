class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    topKFrequent(nums, k) {
        const count = new Map();
        const freq = Array.from({length: nums.length + 1}, () => []);

        for (const num of nums) {
            if (!count[num]) {
                count[num] = 1;
            } else {
                count[num]++;
            }
        }

        for (const num in count) {
            freq[count[num]].push(num);
        }

        const output = [];

        for (let i = freq.length-1; i > 0; i--) {
            for (const num of freq[i]) {
                output.push(num);

                if (output.length === k) {
                    return output;
                }
            }
        }

        return output;
    }
}
