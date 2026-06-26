class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT).replaceAll(" ", "");
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l))) {
                if (l == r) {
                    return true;
                }
                l++;
            }

            while (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            return false;
        }
        return true;
    }
}
