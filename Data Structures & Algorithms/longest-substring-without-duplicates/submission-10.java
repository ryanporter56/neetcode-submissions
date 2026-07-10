class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longestSubstring = 1;
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int r = 1;

        while (l < s.length() - 1 && r < s.length()) {
            charSet.add(s.charAt(l));
            while (r < s.length() && charSet.add(s.charAt(r))) {
                longestSubstring = Math.max(longestSubstring, charSet.size());
                r++;
            }
            l++;
            r=l+1;
            charSet.clear();
        }
        return longestSubstring;
    }
}
