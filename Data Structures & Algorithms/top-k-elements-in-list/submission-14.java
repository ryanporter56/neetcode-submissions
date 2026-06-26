class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberOfOccurrencesMap = new HashMap<>();
        for (int num : nums) {
            numberOfOccurrencesMap.putIfAbsent(num, 0);
            numberOfOccurrencesMap.put(num, numberOfOccurrencesMap.get(num) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for (Map.Entry<Integer, Integer> entry : numberOfOccurrencesMap.entrySet()) {
            Integer value = entry.getKey();
            Integer frequency = entry.getValue();
            
            buckets[frequency].add(value);
        }
        
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length -1; i > 0 && index < k; i--) {
            for (int n : buckets[i]) {
                result[index] = n;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
