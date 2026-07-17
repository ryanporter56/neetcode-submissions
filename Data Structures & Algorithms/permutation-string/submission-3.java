class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int r = s1.length() - 1;
        Map<Character, Integer> charOccurencesMap = new HashMap<>();
        for (Character c: s1.toCharArray()) {
            charOccurencesMap.put(c, charOccurencesMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (null == charOccurencesMap.get(s2.charAt(i))) {
                r++;
                continue;
            }
            Map<Character, Integer> charsLeftMap = new HashMap<>(charOccurencesMap);
            for (int j = i; j <= r; j++) {
                if (null == charsLeftMap.get(s2.charAt(j)) || 0 == charsLeftMap.get(s2.charAt(j))) {
                    break;
                }
                charsLeftMap.put(s2.charAt(j), charsLeftMap.get(s2.charAt(j)) - 1);
                if (j == r) {
                    return true;
                }
            }
            r++;
        }
        return false;
    }
}
