class Solution {
    public int[] twoSum(int[] nums, int target) {
        int indexI = 0;
        int indexJ = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int secondVal = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (secondVal == nums[j]) {
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        return new int[]{indexI, indexJ};
    }
}
