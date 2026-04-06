class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        std::stack<int> stack;

        for (const string& token : tokens) {
            if (token == "+") {
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(a + b);
            } else if (token == "-") {
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(b - a);
            } else if (token == "*") {
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(a * b);
            } else if (token == "/") {
                int a = stack.top();
                stack.pop();
                int b = stack.top();
                stack.pop();
                stack.push(b / a);
            } else {
                stack.push(stoi(token));
            }
        }

        return stack.top();
    }
};
