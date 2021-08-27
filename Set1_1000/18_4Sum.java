// general recursive way for k sum problem template

/*
public List<List<Integer>> kSum(int[] nums, int target, int k, int index,
                                    int len) {

        List<List<Integer>> res = new ArrayList<>();
        int max = nums[len - 1];
        ...
        if (k == 2) {
            // two sum
            ...
        } else {
            for (int i = index; i < len; i++) {

                // START: MAGICAL EDGE CASES
               
                //skip duplicated numbers
                if (i > index && nums[i] == nums[i - 1]) continue;
                
                // check if this `num + last max num * (K-1)` is greater than
                // target 
                if (nums[i] + max * (k - 1) < target) continue;
                
                // checking if smallest number 4 times makes it greater than 
                // target 
                if (nums[i] * k > target) break;

                // END: MAGICAL EDGE CASES

                // use current number to reduce k-sum into k-1sum
                List<List<Integer>> lst = kSum(nums, target - nums[i], k - 1,
                        i + 1, len);

                ...
            }
        }

        return res;
    }
*/


// my solution 


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i=0; i+3<length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            for (int k=j; k+2<length; k++) {
                if (k > j && nums[k] == nums[k - 1])
                    continue;
                int ourAim = target - (nums[i] + nums[k]);
                int left = k + 1;
                int right = length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == ourAim) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));
                        left += 1;
                        right -= 1;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
                    else if (nums[left] + nums[right] > ourAim) {
                        right --;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}