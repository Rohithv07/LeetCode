class Solution {
    public int maxProduct(int[] nums) {
        int current_max = nums[0];
        int max = nums[0];
        int current_min = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int next_max = current_max * nums[i];
            int next_min = current_min * nums[i];
            
            current_max = Math.max(nums[i], Math.max(next_max, next_min));
            current_min = Math.min(nums[i], Math.min(next_min, next_max));
            
            max = Math.max(current_max, max);
        }
        
        return max;
    }
}


Another Solution:

class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;
        int maximumProduct = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            product *= nums[i];
            maximumProduct = Math.max(maximumProduct, product);
            if (product == 0)
                product = 1;
        }
        product = 1;
        for (int i=nums.length-1; i>=0; i--) {
            product *= nums[i];
            maximumProduct = Math.max(maximumProduct, product);
            if (product == 0)
                product = 1;
        }
        return maximumProduct;
    }
}
