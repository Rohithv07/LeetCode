class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length-1;
        int maximum = 0;
        while(leftPointer < rightPointer){
            if (height[leftPointer] < height[rightPointer]){
                maximum = Math.max(maximum, height[leftPointer] * (rightPointer-leftPointer));
                leftPointer += 1;
            }
            else {
                maximum = Math.max(maximum, height[rightPointer] * (rightPointer-leftPointer));
                rightPointer -= 1;
            }
            
        }
        return maximum;
    }
}
