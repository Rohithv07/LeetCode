class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // brute force but here the time complexity will be more and we can optimise it further
        // space O(nums1.length + nums2.length)
        // time O((nums1.length+nums2.length) log(nums1.length + nums2.length))
        int length1 = nums1.length;
        int length2 = nums2.length;
        int [] newArray = new int [length1 + length2];
        int index = 0;
        for (int number: nums1)
            newArray[index++] = number;
        for (int number: nums2)
            newArray[index++] = number;
        Arrays.sort(newArray);
        if ((length1 + length2)  % 2 != 0) {
            int middle = (length1 + length2) / 2;
            return (double) newArray[middle];
        }
        int middle = (length1 + length2) / 2;
        System.out.println(newArray[middle] + newArray[middle-1]);
        double element = (newArray[middle] + newArray[middle-1]) / 2.0;
        return  (double) element;
        
        
        // do binary search on  the smaller array
        // partitionX + partitionY = x + y + 1 / 2
        // we need to find:
        // maxLeftX <= minRightY
        // maxLeftY <= minRightX
        
        // else if 
        // maxLeftX > minRightY, then we are on the rightmost part, so move to the left in X
        // else
        // move towards right in X
        
        
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length2 < length1) 
            return findMedianSortedArrays(nums2, nums1);
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX; // +1 is to deal with both odd and even
            
            // now we need maxLeftX, minRightY, maxLeftY, minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // if x + y == odd, then median = max(maxLeftX, maxLeftY)
                // if x + y ==  even, then median = avg(max(maxLeftX, maxLeftY), min(minRightX, minRightY))
                if ((x + y) % 2 != 0) 
                     return ((double) Math.max(maxLeftX, maxLeftY));
                else 
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            }
            else if (maxLeftX > minRightY)
                // this time we are on the rightmost part, so move to the left
                high = partitionX - 1;
            else
                // we are on the leftMost part, so move to the right
                low = partitionX + 1;
        }
        return 0;
    }
}


// reference video : https://www.youtube.com/watch?v=LPFhl65R7ww
