class MinStack {
public:
    std::stack<int> stack;
    std::stack<int> min;

    MinStack() {
        
    }
    
    void push(int val) {
        stack.push(val);
        if (min.empty() || val < min.top()) {
            min.push(val);
        } else {
            min.push(min.top());
        }
    }
    
    void pop() {
        stack.pop();
        min.pop();
    }
    
    int top() {
        return stack.top();
    }
    
    int getMin() {
        return min.top();
    }
};
