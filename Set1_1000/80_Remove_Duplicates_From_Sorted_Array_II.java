/*

Generally if we need to keep no duplicates, then
int i = 0;
for (int number : nums) {
    if (i < 1 || number > nums[i-1])
        nums[i++] = number;
}
return ;

Now if we need 2 duplicates, then
        int i = 0;
        for (int number : nums) {
            if (i < 2 || number > nums[i-2])
                nums[i++] = number;
        }
        return i;
        
Therefore if we need say k duplicates then
    int i = 0;
    for (int number: nums) {
    if (i < k || number > nums[i-k])
        nums[i++] = number;
    }
    return i;
        

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int number : nums) {
            if (i < 2 || number > nums[i-2])
                nums[i++] = number;
        }
        return i;
    }
}
