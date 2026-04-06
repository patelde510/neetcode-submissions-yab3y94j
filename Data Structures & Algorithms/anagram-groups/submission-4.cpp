class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;

        for (const auto& str : strs) {
            vector<int> freq(26, 0);

            for (const char& c : str) {
                freq[c - 'a']++;
            }

            string key = to_string(freq[0]);
            for (int i = 1; i < 26; ++i) {
                key += ','+ to_string(freq[i]);
            }
            mp[key].push_back(str);
        }

        vector<vector<string>> res;
        for (const auto& pair : mp) {
            res.push_back(pair.second);
        }

        return res;
    }
};
