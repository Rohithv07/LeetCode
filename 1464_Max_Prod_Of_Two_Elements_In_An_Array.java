// Brute force O(n^2)
class Solution {
    public int maxProduct(int[] nums) {
        int product = 0;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                product = Math.max(product, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return product;
    }
}


// Optimised O(n)
/*
Here let us find the 2 maximum value from the array.
Let it be initially 1.
-> If the current number > max1
    then update max2 = max1 and max1 = currentNumber
-> else if current number > max2
    then update max2 = number
    
Finally return max1-1 * max2-1

*/


class Solution {
    public int maxProduct(int[] nums) {
        int maximum1 = 1;
        int maximum2 = 1;
        for (int number: nums) {
            if (number > maximum1) {
                maximum2 = maximum1;
                maximum1 = number;
            }
            else if (number > maximum2) {
                maximum2 = number;
            }
        }
        return (maximum1-1) * (maximum2-1);
    }
}


