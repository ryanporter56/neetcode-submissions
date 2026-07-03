class Solution {
    public int trap(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                if (height[l] > leftMax) {
                    leftMax = height[l];
                }
                result = result + (leftMax - height[l]);
            } else {
                r--;
                if (height[r] > rightMax) {
                    rightMax = height[r];
                }
                result = result + (rightMax - height[r]);
            }
        }
        return result;
    }
}
