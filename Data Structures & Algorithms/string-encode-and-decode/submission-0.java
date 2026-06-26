class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder encodedString = new StringBuilder();
        for (String string : strs) {
            int stringLength = string.length();
            encodedString.append(stringLength).append("#").append(string);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int lengthOfString = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + lengthOfString;
            String stringToExtract = str.substring(i, j);
            result.add(stringToExtract);
            i = j;
        }
        return result;
    }
}
