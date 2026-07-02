class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int smallestValue;
            int smallestIndex = -1;
            if (heights[left] < heights[right]) {
                smallestValue = heights[left];
                smallestIndex = left;
            } else if (heights[left] > heights[right]) {
                smallestValue = heights[right];
                smallestIndex = right;
            } else {
                smallestValue = heights[left];
            }
            int areaOfCurrentPointers = smallestValue * (right - left);
            if (areaOfCurrentPointers > result) {
                result = areaOfCurrentPointers;
            }
            if (smallestIndex == -1) {
                if (heights[left + 1] > heights[right - 1]) {
                    left++;
                } else {
                    right--;
                }
            } else if (smallestIndex == left) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
