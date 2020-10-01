/* 
My thought process
Here I uses a 2 pointer approach.
I have a start pointer and end pointer.Start pointer starts from 0 and end pointer starts from 1.

-> So my idea is if number[start] is 1 and number[end] is also 1 then we calculate the distance between them.
-> If the distance < k, we can directly return false.
-> Otherwise we can check whether we reach the end pointer to the last of array, if not we have to move our start pointer to the position of current end pointer.
-> These steps are done when we have both nums[start] and nums[end] = 1.
-> If its not the condition, if nums[start] != 1, then we have to move the start pointer by 1 and we stop our start pointer only if we see a 1.


-> If all these conditions satisfies and we gets out of the loop, then we can return true.

1)             2)               3)              4)                 5) Updated s to e   6)               7)
s e              s   e            s     e          s - 3 - e                s e                 s   e            s -2- e
1 0 0 0 1 0 0 1  1 0 0 0 1 0 0 1  1 0 0 0 1 0 0 1  1 0 0 0 1 0 0 1  1 0 0 0 1 0 0 1     1 0 0 0 1 0 0 1  1 0 0 0 1 0 0 1


*/



class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        if (k > nums.length)
            return false;
        int length = nums.length;
        int start = 0;
        for (int end=1; end<length; end++) {
            int distance = 0;
            if (nums[start] == 1 && nums[end] == 1) {
                    distance = end - start - 1;
                    if (distance < k)
                        return false;
                    else {
                        if (end != length) {
                            start = end;
                        }
                    }
                }
            else if (nums[start] != 1)
                start += 1;
            }
        return true;
    }
}
