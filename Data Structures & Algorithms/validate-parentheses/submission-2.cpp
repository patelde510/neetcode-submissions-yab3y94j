class Solution {
public:
    bool isValid(string s) {
        std::stack<char> stack;
        unordered_map<char, char> mp = {
            {'}', '{'},
            {']', '['},
            {')', '('}
        };

        for (char c : s) {
            if (mp.count(c)) {
                if (!stack.empty() && stack.top() == mp[c]) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.empty();
    }
};
