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

// using suffix and prefix product and comparing max

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int suffix = 0;
        int prefix = 0;
        int result = 0;
        for (int i=0; i<length; i++) {
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[length - i - 1];
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
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
