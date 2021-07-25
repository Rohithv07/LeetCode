class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int [] result = new int [length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                result[stack.pop()] += 1;
            }
            if (!stack.isEmpty()) {
                result[stack.peek()] ++;
            }
            stack.push(i);
        }
        return result;
    }
}

// peek < current array element -> monotonic increasing
// peek > current array element -> monotonic decreasing


