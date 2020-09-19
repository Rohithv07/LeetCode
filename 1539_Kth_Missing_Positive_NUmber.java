// Binary Search Solution

public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] - (mid + 1) >= k) r = mid;  //missed more or equal than k numbers, left side;
            else l = mid + 1;   // missed less than k numbers, must be in the right side;
        }
        return l + k;
    }




/* My thought process
At first I tried to approach the problem by using a list and adding the missing numbers to the list and then if the size of list reaches k, then return the last number added to the list. But this approach will be too slow in case of both time and space. SO I just look through the discuss section and got a wonderful idea.

So here we traverse through the array only once and check for the availability of number if not found we incremeent a counter and if this counter reaches k, then we met the problem statemment and we can just return the j, else continue with next i and next j

Here i = iterate varible, j = first missing variable.
*/



class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int j = 1;
        int trackCount = 0;
        while (i<arr.length) {
            if (arr[i] != j) {
                trackCount += 1;
                if (trackCount == k)
                    return j;
                j ++;
            }
            else {
                i += 1;
                j += 1;
            }
        }
        return arr.length + k;
    }
}

