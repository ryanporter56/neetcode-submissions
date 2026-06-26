class Solution {
    public boolean hasDuplicate(int[] nums) {

        if (nums.length <= 1) {
            return false;
        }

        List<Integer> nonDuplicateList = new ArrayList<>();
        nonDuplicateList.add(nums[0]);
        for (int i=1; i < nums.length; i++) {
            if (nonDuplicateList.contains(nums[i])) {
                return true;
            }
            nonDuplicateList.add(nums[i]);
        }
        return false;
    }
}