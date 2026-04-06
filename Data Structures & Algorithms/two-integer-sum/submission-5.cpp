class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        unordered_map<int, int> diff;

        for (int i = 0; i < n; i++) {
            int difference = target - nums[i];
            if (diff.count(difference)) {
                return {diff[difference], i};
            }
            diff.insert({nums[i], i});
        }
    }
};
