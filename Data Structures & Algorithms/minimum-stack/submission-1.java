class MinStack {

    private Deque<Integer> minStack;
    private Map<Integer, Integer> minMap;

    public MinStack() {
        this.minStack = new ArrayDeque<>();
        this.minMap = new HashMap<>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(val);
            minMap.put(minStack.size(), val);
        } else {
            int minValue = minMap.get(minStack.size()) > val ? val : minMap.get(minStack.size());
            minStack.push(val);
            minMap.put(minStack.size(), minValue);
        }
    }

    public void pop() {
        minMap.remove(minStack.size());
        minStack.pop();
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minMap.get(minStack.size());
    }
}
