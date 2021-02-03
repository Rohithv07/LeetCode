class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int answer = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else 
                    answer += leftMax - height[left];
                left += 1;
            }
            else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else 
                    answer += rightMax - height[right];
                right -= 1;
            }
        }
        return answer;
    }
}
