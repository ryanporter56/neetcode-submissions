class Solution {
    public static int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> timeToArriveStack = new ArrayDeque<>();
        Map<Integer, Integer> posSpeedMap = new HashMap<>(); // position, speed
        for (int i = 0; i < speed.length; i++) {
            posSpeedMap.put(position[i], speed[i]);
        }
        for (int i = target; i >= 0; i--) {
            if (!posSpeedMap.containsKey(i)) {
                continue;
            }
            double time = (double) (target - i) / posSpeedMap.get(i);
            if (timeToArriveStack.isEmpty()) {
                timeToArriveStack.push(time);
            } else if (timeToArriveStack.peek() < time) {
                timeToArriveStack.push(time);
            } else {
                continue;
            }
        }
        return timeToArriveStack.size();
    }
}
