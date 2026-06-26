class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Integer, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charCountMap.put(s.charAt(i) - 'a', charCountMap.getOrDefault(s.charAt(i) - 'a', 0) + 1);
            charCountMap.put(t.charAt(i) - 'a', charCountMap.getOrDefault(t.charAt(i) - 'a', 0) - 1);
        }

        for (Integer value : charCountMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
