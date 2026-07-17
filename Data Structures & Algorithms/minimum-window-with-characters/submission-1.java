class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s.length() < t.length()) {
            return result;
        }
        Map<Character, Integer> charOccurrencesMap = new HashMap<>();
        for (Character c: t.toCharArray()) {
            charOccurrencesMap.put(c, charOccurrencesMap.getOrDefault(c, 0) + 1);
        }
        boolean shortestSubstringFound = false;
        int[] shortestSubstring = new int[2];
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            if (null == charOccurrencesMap.get(s.charAt(l)) || 0 == charOccurrencesMap.get(s.charAt(l))) {
                l++;
                r++;
                continue;
            }
            int charsFound = 0;
            Map<Character, Integer> copyMap = new HashMap<>(charOccurrencesMap);
            for (Character c: s.substring(l).toCharArray()) {

                if (null != copyMap.get(c) && 0 != copyMap.get(c)) {
                    copyMap.put(c, copyMap.get(c) - 1);
                    charsFound++;
                }
                r++;
                if (charsFound == t.length()) {
                    break;
                }
            }
            if (charsFound == t.length()) {
                if (!shortestSubstringFound) {
                    shortestSubstring[0] = l;
                    shortestSubstring[1] = r;
                    shortestSubstringFound = true;
                }
                if ((shortestSubstring[1] - shortestSubstring[0]) > (r - l)) {
                    shortestSubstring[0] = l;
                    shortestSubstring[1] = r;
                }
            }
            l++;
            r = l;
        }
        result = s.substring(shortestSubstring[0], shortestSubstring[1]);
        return result;
    }
}
