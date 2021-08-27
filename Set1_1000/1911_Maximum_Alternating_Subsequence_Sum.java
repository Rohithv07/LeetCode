class Solution {
    public long maxAlternatingSum(int[] nums) {
        // dp ref : https://www.youtube.com/watch?v=9OAA38ymTGo
        long even = 0;
        long odd = 0;
        for (int number : nums) {
            long newEven = Math.max(even, (long)odd-number);
            odd = Math.max(odd, (long)even + number);
            even = newEven;
        }
        return Math.max(odd, even);
    }
}

/*

consider the number and find what might be the sum ending with even or odd index

nums = [[6,2,1,2,4,5]]
odd  - 0
even - 0

1st number = 6
neweven = max(0, 0 - 6) = 0
odd = max(0, 0 + 6) = 6
even = newEven = 0

2nd number = 2
newEven = max(0, 6 - 2) = 4
odd = max(6, 0 + 2) = 6
even = newEven = 4

3rd number = 1
newEven = max(4, 6 - 1) = 5
odd = max(6, 4 + 1) = 6
even = newEven = 5

4th number = 2
newEven = max(5, 6 - 2) = 5
odd = max(6, 5 + 2) = 7
even = newEven = 5

5th number = 4
newEven = max(5, 7 - 4) = 5
odd = max(7, 5 + 4) = 9
even = newEven = 5

6th number = 5
newEven = max(5, 9 - 5) = 5
odd = max(9, 5 + 5) = 10
even = newEven = 5

finally result is max(even, odd) = (10, 5) = 5



*/
