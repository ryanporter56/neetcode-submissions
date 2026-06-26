class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> arrayBasedAnagram = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] numOfLetters = new int[26];
            char[] charArray = strs[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                int charValue = Character.getNumericValue(charArray[j]) - Character.getNumericValue('a');
                numOfLetters[charValue]++;
            }
            String key = Arrays.toString(numOfLetters);
            arrayBasedAnagram.putIfAbsent(key, new ArrayList<>());
            arrayBasedAnagram.get(key).add(strs[i]);
        }
        return new ArrayList<>(arrayBasedAnagram.values());
    }
}
