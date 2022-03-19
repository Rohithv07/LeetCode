class Solution {
    public boolean divideArray(int[] nums) {
        int [] visited = new int [501];
        int length = nums.length;
        for (int num : nums) {
            visited[num]++;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}