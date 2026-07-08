class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < t) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return result;
    }
}
