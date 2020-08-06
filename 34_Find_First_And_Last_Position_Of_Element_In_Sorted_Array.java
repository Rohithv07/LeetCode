class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums.length == 0)
        return new int[]{-1, -1};
        
        int low= 0;
        int high = nums.length - 1;
        int middle = 0;
        
        
        
        while(low <= high){
            middle = (low + high) / 2;
            if (nums[middle] == target){
                break;
            }
                
            else if (nums[middle] > target)
                high = middle - 1;
            else
                low = middle + 1;
        }
        
        if (nums[middle] != target)
            return new int[]{-1, -1};
        
        int starting_index = middle;
        int ending_index = middle;
        for(int i = middle + 1; i <= high; i++){
            if (nums[i] == target)
                ending_index = i;
        } for(int i = middle - 1; i >= 0; i--){
            if (nums[i] == target)
                starting_index = i;
        }
       return new int[]{starting_index, ending_index};
        
    }
}
