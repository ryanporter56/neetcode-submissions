class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // construct frequency map
        Map<Integer, Integer> numberOfOccurrencesMap = new HashMap<>();
        for (int num : nums) {
            numberOfOccurrencesMap.put(num, numberOfOccurrencesMap.getOrDefault(num, 0) + 1);
        }

        // Create buckets where index = frequencies, and each bucket stores numbers with that frequency.
        // I am creating length + 1 buckets, as the number of occurrences can range from 0, to the length of the array.
        // Creating a number of buckets only equal to the length of the array will cause an array out of bounds exception,
        // if there is only one distinct number in the array.
        // Example: [3,3,3,3]
        // We will create buckets for 0, 1, 2, 3, 4 occurrences. This is one greater than the array length.
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        // Initialise buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add value to the correct bucket, in the example of [1,1,2,2,2,3,3,3,3]
        // The value '1' will be added to the bucket at index 2
        // The overall array of buckets would be printed like this:
        // index: 0   1    2    3    4   5   6   7   8   9
        //       [[], [], [1], [2], [3], [], [], [], [], []]
        for (Map.Entry<Integer, Integer> entry : numberOfOccurrencesMap.entrySet()) {
            Integer value = entry.getKey();
            Integer frequency = entry.getValue();

            buckets[frequency].add(value);
        }

        int[] result = new int[k];
        int index = 0;

        // loop through the buckets array of lists, starting at the highest frequency bucket, and work down by decrementing the pointer
        for (int i = buckets.length -1; i > 0 && index < k; i--) {
            //This loop handles the scenario of more than one element in the list, for a specified bucket
            for (int n : buckets[i]) {
                result[index] = n;
                index++;
                // return when k elements have been added to this result array
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
