class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        //Initialise buckets

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        // add numbers to buckets
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer number = entry.getKey();
            Integer frequency = entry.getValue();
            buckets[frequency].add(number);
        }
        
        int index = 0;
        for (int i = nums.length; i > 0 && index < k; i--) {
            if (null != buckets[i]) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    if (index == k) {
                        return result;
                    }
                    result[index] = buckets[i].get(j);
                    index += 1;
                }
            }
        }
        return result;
    }
}
