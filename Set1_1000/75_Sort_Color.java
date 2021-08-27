// 1. Not One pass

class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0)
                count0 += 1;
            else if (nums[i] == 1)
                count1 += 1;
            else if (nums[i] == 2)
                count2 += 1;
        }   
        int zeroOneCount = count0 + count1;
        for (int i=0; i<count0; i++)
            nums[i] = 0;
        for (int i=count0; i<zeroOneCount; i++)
            nums[i] = 1;
        for (int i=zeroOneCount; i<nums.length; i++)
            nums[i] = 2;
    }
}

// 2. One Pass(1 loop)

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int index = 0;
        int end = nums.length-1;
        while(start < end && index <= end){
            if (nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start ++;
                index ++;
            }
            else if (nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end --;
            }
            else {
                index ++;
            }
        }
    }
}
