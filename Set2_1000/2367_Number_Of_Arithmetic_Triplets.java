

// brute force
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int length = nums.length;
        int countTriplet = 0;
       
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = i + 2; k < length; k++) {
                    if (nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) {
                        countTriplet++;
                    }
                }
            }
            
        }
        return countTriplet;
    }
}

// optimised using hashset to check n - diff and n - 2 * diff

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int length = nums.length;
        int countTriplet = 0;
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - diff) && visited.contains(num - 2 * diff)) {
                countTriplet++;
            }
            visited.add(num);
        }
        return countTriplet;
    }
}