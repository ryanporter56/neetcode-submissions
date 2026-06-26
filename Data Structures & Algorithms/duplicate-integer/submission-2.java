class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean isPresent = intSet.add(nums[i]);
            if (!isPresent) {
                return true;
            }
        }
        return false;
    }
}