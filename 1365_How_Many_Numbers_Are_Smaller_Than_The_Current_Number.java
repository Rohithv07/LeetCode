/*
O(n^2) brute force
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int [] result = new int [length];
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (i!=j && nums[j] < nums[i])
                    result[i] += 1;
            }
        }
        return result;
    }
}


/*
Bucket Sort- O(n)
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 0 <= nums[i] <= 100
        
        // take example [8,1,2,2,3]
        int [] count = new int[101];
        int length = nums.length;
        int [] result = new int [length];
        for (int i=0; i<length; i++) {
            count[nums[i]] += 1;
            // count pass 1 = [0, 1, 2, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }
        // calculate the running sum
        for (int i=1; i<=100; i++) {
            count[i] += count[i-1];
        }
        // count pass 2 = [0, 1, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
        for (int i=0; i<length; i++) {
            if (nums[i] == 0)
                result[i] = 0;
            else
                result[i] = count[nums[i]-1];
        }
        return result;
    }
}
