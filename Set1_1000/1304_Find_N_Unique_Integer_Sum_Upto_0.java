/*
Here the idea is whenever we gave a positive integer, take its corresponding negative integer also so that the total sum will be 0.
So I started by using 2 pointers from left most point of array and rightmost point of array
-> The looping condition given is left <= right and left = right condition hits only when the given n is odd
-> So when the number is odd, we fill  values as discussed above and when we reach the middle, ie, left == right, then we place value 0 there so that all the total sum = 0
-> Whene number is not odd, left == right will not hit and we can perfectly fill all the values with a number positive and negative respectively.
*/


class Solution {
    public int[] sumZero(int n) {
        int [] result = new int [n];
        int left = 0;
        int right = n - 1;
        int i = 1;
        while (left <= right)  {
            if (left == right)
                result[left] = 0;
            else {
                result[left] = i;
                result[right] = -i;
                i += 1;
            }
            left += 1;
            right -= 1;
        }
        return result;
    }
}
