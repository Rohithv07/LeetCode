// HashMap

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }
        return -1;
    }
}
//Binary Search

// before finding the unique element, the nunbers will be in pairs starting at even index and ending at odd index
// but after finding the uniqeue element, the other pairs will start at odd index and end at even index
// the unique element will be at even index
// ref : https://www.youtube.com/watch?v=nMGL2vlyJk0&list=PLEJXowNB4kPwR6C6yq3BzS-Jkyc6XE8kE&index=12
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        if (right == 0)
            return nums[0];
        // boundary check
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle - 1] != nums[middle] && nums[middle] != nums[middle + 1])
                return nums[middle];
            if ((middle % 2 != 0 && nums[middle] == nums[middle - 1]) || (middle % 2 == 0 && nums[middle] == nums[middle + 1]))
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
	}
}
Another approach using BinarySearch
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length / 2;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle * 2] != nums[middle * 2 + 1])
                right = middle;
            else
                left = middle + 1;
        }
        return nums[left * 2];
    }
}
