class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> valueIndexMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (valueIndexMap.containsKey(numbers[i])) {
                valueIndexMap.get(numbers[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                valueIndexMap.put(numbers[i], indexList);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (complement != numbers[i] && valueIndexMap.containsKey(complement)) {
                return new int[] {i+1, valueIndexMap.get(complement).get(0) + 1};
            } else if (complement == numbers[i] && valueIndexMap.containsKey(complement) && valueIndexMap.get(complement).size() > 1) {
                List<Integer> elementsToReturn = valueIndexMap.get(complement);
                return new int[] {elementsToReturn.get(0) + 1, elementsToReturn.get(1) + 1};
            }
        }
        return new int[2];
    }
}
