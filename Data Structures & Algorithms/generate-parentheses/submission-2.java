class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder stack = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(0, 0, n, stack, res);

        return res;
    }

    public void backtrack(int openN, int closedN, int n, StringBuilder stack, List<String> res) {
        if (openN == closedN && closedN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, stack, res);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, stack, res);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
