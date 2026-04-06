class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const seen = new Map();

        for (let i = 0; i < nums.length; i++) {
            let goal = target - nums[i];
            if (seen.has(goal)) {
                return [seen.get(goal), i];
            }
            seen.set(nums[i], i);
        }

        return [];
    }
}
