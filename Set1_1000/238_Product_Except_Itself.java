class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] outputArray = new int[nums.length];
        int product = 1;
        int productNonZero = 1;
        int countZero = 0;
        for (int number: nums){
            product *= number;
            if (number == 0)
                countZero ++;
            else
                productNonZero *= number;
        }
        if (product != 0){
            for (int i=0; i<nums.length; i++){
                outputArray[i] = product / nums[i];
            }
        }
        else {
            if (countZero == 1){
                for (int i=0; i<nums.length; i++){
                    if (nums[i] == 0)
                        outputArray[i] = productNonZero;
                }
            }
        }
        return outputArray;
    }
}


class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        This is second possible method without using division
        int [] left = new int [nums.length];
        int [] right = new int [nums.length];
        int [] answer = new int [nums.length];
        left[0] = 1;
        for (int i=1; i<nums.length; i++) 
            left[i] = nums[i-1] * left[i-1];
        right[nums.length - 1] = 1;
        for (int i=nums.length - 2; i>=0; i--)
            right[i] = nums[i+1] * right[i+1];
        for (int i=0; i<nums.length; i++)
            answer[i] = left[i] * right[i];
        return answer;
        */
        // 3rd method without division
        int [] answer = new int[nums.length];
        answer[0] = 1;
        for (int i=1; i<nums.length; i++)
            answer[i] = answer[i-1] * nums[i-1];
        int right = 1;
        for (int i = nums.length-1; i>=0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }
        return answer;
    }
}
