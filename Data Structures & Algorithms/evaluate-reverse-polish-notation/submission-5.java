class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String c: tokens) {
            if ("+".equals(c)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            } else if ("-".equals(c)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if ("*".equals(c)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            } else if ("/".equals(c)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
