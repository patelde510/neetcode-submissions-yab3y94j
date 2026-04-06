class Solution {
public:
    void backtrack(int openN, int closedN, int n, string& stack, vector<string>& res) {

        if (openN == closedN && closedN == n) {
            res.push_back(stack);
            return;
        }

        if (openN < n) {
            stack += '(';
            backtrack(openN + 1, closedN, n, stack, res);
            stack.pop_back();
        }

        if (closedN < openN) {
            stack += ')';
            backtrack(openN, closedN + 1, n, stack, res);
            stack.pop_back();
        }

    }
    vector<string> generateParenthesis(int n) {
        string stack;
        vector<string> res;
        backtrack(0, 0, n, stack, res);
        return res;
    }
};
