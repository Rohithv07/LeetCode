/*
If we assume the number will be modified to some value say C and this C is the value the array have at middle, then from last element of array,  the array element > C, then we have to subtract C it and after middle element, array element < C, then we have to subtract from C
ie
nums[last] - C + nums[last - 1] - C + ….. + C - nums[mid- 1] + C - nums[mid - 2]+ …. + C - nums[0]
where C gets cancelled and we get 
nums[last] - nums[0] + nums[last - 1] - nums[1].....
this some gives the min number of moves to make array equal

*/


class Solution {
    public int minMoves2(int[] nums) {
        	int length = nums.length;
		Arrays.sort(nums);
		int low = 0;
		int high = length - 1;
		int count = 0;
		while (low < high) {
			count += nums[high] - nums[low];
			high -= 1;
			low += 1;
		}
		return count;
    }
}

