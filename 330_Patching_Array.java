// // https://youtu.be/SPBXNJKLWr4
class Solution {
    public int minPatches(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        long max = 0; // as there might be wrong if target = Integer.max
        int count = 0;
        for (int number : nums) {
            /*
            nums = [1,5,10], n = 20
            1 -> 1
            2 -> 1 + 2 = upto 3 - patch = 1
            3 -> already covered if we added 2 - no need to patch. as it is already covered
            4 -> 4 + 3 = upto 7 will be covered - patch = 2
            5 -> 5 + 7 = upto 12 will be covered
            6 - not requered already covered
            7, 8, 9 - already covered
            10 - its in the given array and 10 + 12 = upto 22 will be covered
            so minimum of 2 patches must be required
            */
            while (number > max + 1) {
                max += max + 1;
                count += 1;
                if (max >= target) {
                    return count;
                }
            }
            // now number become < max, so add it as it will be covered
            max += number;
            if (max >= target) {
                return count;
            }
        }
        // if we reach here, we still didn't coverd the whole target so, repeat until we cover them
        while (target > max) {
            max += max + 1;
            count += 1;
        }
        return count;
    }
}