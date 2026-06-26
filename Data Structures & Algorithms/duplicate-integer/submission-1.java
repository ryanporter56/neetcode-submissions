class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Integer arrayLength = nums.length;
        for (Integer i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (arrayLength != set.size()) {
            return true;
        }
        return false;
    }
}