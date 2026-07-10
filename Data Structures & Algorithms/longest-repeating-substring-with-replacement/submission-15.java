class Solution {
    public int characterReplacement(String s, int k) {
        int result = 1;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int l = 0;
        int r = 0;
        while (l < s.length() - 1 && r < s.length()) {
            frequencyMap.put(s.charAt(r), frequencyMap.getOrDefault(s.charAt(r),  0) + 1);
            if (frequencyMap.values().stream().reduce(Integer::sum).get() - frequencyMap.values().stream().max(Integer::compareTo).get() <= k) {
                r++;
                result = Math.max(result, r - l);
            } else {
                while (frequencyMap.values().stream().reduce(Integer::sum).get() - frequencyMap.values().stream().max(Integer::compareTo).get() > k ) {
                    frequencyMap.put(s.charAt(l), frequencyMap.get(s.charAt(l)) - 1);
                    l++;
                }
                frequencyMap.put(s.charAt(r), frequencyMap.get(s.charAt(r))-1);
            }
        }
        return result;
    }
}
