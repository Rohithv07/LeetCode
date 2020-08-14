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
