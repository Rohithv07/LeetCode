class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;
        int [] interval = new int[]{0, 0};
        int jump = 0;
        while(true){
            ++jump;
            int canReach = 0;
            for (int i=interval[0]; i<=interval[1]; i++){
                canReach = Math.max(canReach, i+nums[i]);
            }
            if (canReach >= n-1)
                return jump;
            interval[0] = interval[1] + 1;
            interval[1] = canReach;
        }
    }
}

// another approach

class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 0;
        int currentEnd = 0;
        int currentFar = 0;
        int jumps = 0;
        for (int i=0; i<length - 1; i++) {
            currentFar = Math.max(currentFar, i + nums[i]);
            if (i == currentEnd) {
                jumps += 1;
                currentEnd = currentFar;
            }
        }
        return jumps;
    }
}
