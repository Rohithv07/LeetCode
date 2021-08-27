class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] newArray = new int[2 * n];
        for (int i=0; i<2*n; i++) {
            if (i % 2 == 0)
                newArray[i] = nums[i / 2];
            else
                newArray[i] = nums[n + (i/2)];
        }
            
        return newArray;
    }
}


class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] result = new int [nums.length];
        int index = 0;
        for (int i=0; i<n; i++) {
            result[index] = nums[i];
            result[index+1] = nums[nums.length - n + i];
            index += 2;
        }
        return result;
    }
}
