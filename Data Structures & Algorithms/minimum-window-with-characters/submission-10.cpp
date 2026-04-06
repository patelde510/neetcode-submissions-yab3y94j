class Solution {
public:
    string minWindow(string s, string t) {
        if (t.empty()) {
            return "";
        }

        unordered_map<char, int> tCount;
        unordered_map<char, int> window;

        for (char c : t) {
            tCount[c]++;
        }

        int have = 0;
        int need = tCount.size();
        pair<int, int> res = {-1, -1};
        int resLength = INT_MAX;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s[r];
            window[c]++;
            if (tCount.count(c) && window[c] == tCount[c]) {
                have++;
            }

            while (have == need) {
                if ((r-l+1) < resLength) {
                    resLength = r-l+1;
                    res = {l, r};
                }

                char leftChar = s[l];

                window[leftChar]--;

                if (window.count(leftChar) && window[leftChar] < tCount[leftChar]) {
                    have--;
                }
                l++;
            }
        }

        return resLength == INT_MAX ? "" : s.substr(res.first, res.second-res.first+1);
    }
};
