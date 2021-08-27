class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int max = 0;
        int length = heights.length;
        int [] left = new int [length];
        int [] right = new int [length];
        left[0] = -1;
        right[length - 1] = length;
        for (int i=1; i<length; i++) {
            int currentIndex = i - 1;
            while (currentIndex >= 0 && heights[currentIndex] >= heights[i]) {
                currentIndex = left[currentIndex];
            }
            left[i] = currentIndex;
        }
        for (int i=length - 2; i>=0; i--) {
            int currentIndex = i + 1;
            while (currentIndex < length && heights[currentIndex] >= heights[i]) {
                currentIndex = right[currentIndex];
            }
            right[i] = currentIndex;
        }
        for (int i=0; i<length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}

// using stack
class Solution {
     public int largestRectangleArea(int[] heights) {
         int length = heights.length;
         int max = 0;
         Stack<Integer> stack = new Stack<>();
         for (int i=0; i<=length; i++) {
             int currentHeight = (i == length ? 0 : heights[i]);
             if (stack.isEmpty() || currentHeight >= heights[stack.peek()]) {
                 stack.push(i);
             }
             else {
                 int pop = stack.pop();
                 max = Math.max(max, heights[pop] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                 i -= 1;
             }
         }
         return max;
     }
}
