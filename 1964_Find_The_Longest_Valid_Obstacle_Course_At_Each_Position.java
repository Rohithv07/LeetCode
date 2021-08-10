// normal n^2 LIS will be tle
// we need to do in nlogn

// this gives tle
/*
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        if (obstacles == null || obstacles.length == 0)
            return new int [] {};
        int length = obstacles.length;
        int [] result = new int [length];
        Arrays.fill(result, 1);
        return longestIncreasingSubsequence(obstacles, result, length);
    }
    
    public int [] longestIncreasingSubsequence(int [] obstacles, int [] result, int length) {
        for (int i=1; i<length; i++) {
            for (int j=0; j<i; j++) {
                if (obstacles[i] >= obstacles[j] && result[i] <= result[j] + 1) {
                    result[i] = result[j] + 1;
                }
            }
        }
        return result;
    }
 }
 */
// using binary search
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        if (obstacles == null || obstacles.length == 0) {
            return new int [] {};
        }
        return longestIncreasingSubsequence(obstacles);
    }
    
    public int [] longestIncreasingSubsequence(int [] obstacles) {
        int length = obstacles.length;
        int currentIncreasing = 0;
        int [] result = new int [length];
        int [] increasing = new int [length];
        int currentIndex = -1;
        int currentSize = -1;
        for (int i=0; i<length; i++) {
            int currentObstacle = obstacles[i];
            if (currentIndex == -1 || currentObstacle >= result[currentIndex]) {
                result[++currentIndex] = currentObstacle;
                currentSize = currentIndex;
            }
            else {
                currentSize = binarySearch(result, 0, currentIndex, currentObstacle); // index of smallest number greater than obstacles[i]
                result[currentSize] = currentObstacle;
            }
            increasing[currentIncreasing++] = currentSize + 1;
        }
        return increasing;
    }
    
    public int binarySearch(int [] result, int low, int high, int key) {
        int index = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (result[middle] > key) {
                index = middle;
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return index;
    }
 }