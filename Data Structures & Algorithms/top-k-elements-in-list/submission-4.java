class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberOfOccurrencesMap = new HashMap<>();
        for (int num : nums) {
            numberOfOccurrencesMap.putIfAbsent(num, 0);
            numberOfOccurrencesMap.put(num, numberOfOccurrencesMap.get(num) + 1);
        }

        int i = 0;
        int[] topKFrequentAns = new int[k];
        while (i < k) {
            ArrayList<Integer> listOfVals = new ArrayList<>(numberOfOccurrencesMap.values());
            listOfVals.sort(Comparator.naturalOrder());
            Integer numberOfOccurrences = listOfVals.get(listOfVals.size() - i - 1);
            for (Integer key : numberOfOccurrencesMap.keySet()) {
                if (Objects.equals(numberOfOccurrencesMap.get(key), numberOfOccurrences)) {
                    topKFrequentAns[i] = key;
                    i++;
                }
            }
        }
        return topKFrequentAns;
    }
}
