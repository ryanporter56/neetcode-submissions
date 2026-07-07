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
            if (minMap.get(minStack.size()) > val) {
                minStack.push(val);
                minMap.put(minStack.size(), val);
            } else {
                minStack.push(val);
                minMap.put(minStack.size(), minMap.get(minStack.size() - 1));
            }
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
