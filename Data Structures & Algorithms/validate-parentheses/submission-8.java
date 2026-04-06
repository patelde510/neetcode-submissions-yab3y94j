class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closed = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        closed.put('}', '{');
        closed.put(')', '(');
        closed.put(']', '[');

        for (char c : s.toCharArray()) {
            if (closed.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek().equals(closed.get(c))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
