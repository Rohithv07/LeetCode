/*
The idea here is to use a hashmap
Here consider whenever we see a 0, take it as -1 and whenever we see a 1, take it as normal one
Now we go through the array and calculate a running sum.
Each time, we will track the sum and index inside the hasmap, and when we see a sum value that was already added onto the hashmap, then we are hitting a possible contiguos subarray and comapre this value with the length.

[1,1,1,0,0,1,1] -> consider this example

1. Initially
key | value
0     -1

2. Now start iterating through the nums array and let us hold a possible length value as possible = 0

3. i = 0, number = 1, sum += 1 = 1
this is not inside the hashmap, so we put the sum inside the hashmap along with index i 
key | value
0     -1
1      0

4. i = 1, number = 1, sum = 1 + 1 = 2
this is not inside the hashmap, so we put it along with index
key | value
0      -1
1      0
2      1

5. i = 2, number = 1, sum = 2 + 1 = 3
this is not inside the hashmap, so we put it along with index
key | value
0      -1
1      0
2      1
3      2

[1,1,1,0,0,1,1]
6. i = 3, number = 0. Consider it as -1 and add it with sum, sum = 3 - 1 = 2
key | value
0      -1
1      0
2      1
3      2
this is inside the hashmap and the from 3rd index to 4 th index which is [1, 0],we have possible length of 2 = i - map.get(2) = 3 - 1 = 2. So our possible = max(2, 0) = 2

7. i = 4, number = 0, sum = 2 - 1 = 1
key | value
0      -1
1      0
2      1
3      2
this is inside the hashmap and from 1st index to 4th index which is [1, 1, 0, 0], we have a possible length of 4 = i - map.get(1) = 4 - 0 = 4. Now possible = max(2, 4) = 4

8. i = 5, number = 1, sum = 1 + 1 = 2
key | value
0      -1
1      0
2      1
3      2
this is inside the hashmap and from 2nd index to 5th index which is [1, 0, 0, 0], we have a possible length of 4 = i - map.get(2) = 5 - 1 = 4. Now possible = max(4, 4) = 4

9. i = 6, number = 1, sum = 2 + 1 = 3
key | value
0      -1
1      0
2      1
3      2
this is inside the hashmap and from 3rd  index to 6th index which is [0, 0, 1, 1], we have a possible length of 4 = i - map.get(3) = 6 - 2 = 4. Now possible = max(4, 4) = 4

So we have maximum of 4 length and this is the answer for the largest contiguos subarray with same count of 0s and 1s
*/

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int possible = 0;
        map.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            int number = nums[i];
            if (number == 0) {
                sum -= 1;
            }
            else {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                possible = Math.max(i - map.get(sum), possible);
            }
            else {
                map.put(sum, i);
            }
        }
        return possible;
    }
}
