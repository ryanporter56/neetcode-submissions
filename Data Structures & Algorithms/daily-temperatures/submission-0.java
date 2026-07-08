class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> monotonicStack = new ArrayDeque<>(); // temp, index
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!monotonicStack.isEmpty() && monotonicStack.peek()[0] < t) {
                int[] pair = monotonicStack.pop();
                result[pair[1]] = i - pair[1];
            }
            monotonicStack.push(new int[]{t, i});
        }
        return result;
    }
}
