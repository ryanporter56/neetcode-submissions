class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isCharOpenBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (isCharClosedBracket(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                char stackChar = stack.pop();
                if (!bracketCorrespondsWithOneInStack(s.charAt(i), stackChar)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean bracketCorrespondsWithOneInStack(char c, char stackChar) {
        if (stackChar == '{' && c == '}') {
            return true;
        } else if (stackChar == '(' && c == ')') {
            return true;
        } else if (stackChar == '[' && c == ']') {
            return true;
        }
        return false;
    }

    private static boolean isCharClosedBracket(char c) {
        if (c == '}' || c == ']' || c == ')') {
            return true;
        }
        return false;
    }

    private static boolean isCharOpenBracket(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        }
        return false;
    }
}
