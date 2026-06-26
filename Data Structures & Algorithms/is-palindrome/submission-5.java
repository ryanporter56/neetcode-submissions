class Solution {
    public boolean isPalindrome(String s) {
        String lowerCaseString = s.toLowerCase();
        int l = 0;
        int r = lowerCaseString.length() - 1;

        while (l < r) {

            while (!Character.isLetterOrDigit(lowerCaseString.charAt(l)) && l<r) {
                l++;
            }

            while (!Character.isLetterOrDigit(lowerCaseString.charAt(r)) && l<r) {
                r--;
            }

            if (lowerCaseString.charAt(l) != lowerCaseString.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}
