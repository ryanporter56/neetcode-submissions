class Solution {
    public boolean isAnagram(String s, String t) {
        List<String> sList = Arrays.asList(s.split(""));
        List<String> tList = Arrays.asList(t.split(""));

        sList.sort(String::compareTo);
        tList.sort(String::compareTo);

        if (sList.equals(tList)) {
            return true;
        }

        return false;
    }
}
