// https://www.youtube.com/watch?v=k8I7F8ImzcI

class Solution {
    public int minimumOperations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int [] freqEven = new int [100001];
        int [] freqOdd = new int [100001];
        int length = nums.length;
        int maximum = nums[0];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                freqEven[nums[i]]++;
            }
            else {
                freqOdd[nums[i]]++;
            }
            if (maximum <= nums[i]) {
                maximum = nums[i];
            }
        }
        int firstMaxEven = 0;
        int freqFirstMaxEven = 0;
        int firstMaxOdd = 0;
        int freqFirstMaxOdd = 0;
        
        int secondMaxEven = 0;
        int freqSecondMaxEven = 0;
        int secondMaxOdd = 0;
        int freqSecondMaxOdd = 0;
        
        for (int i = 0; i <= maximum; i++) {
            if (freqEven[i] >= freqFirstMaxEven) {
                secondMaxEven = firstMaxEven;
                freqSecondMaxEven = freqFirstMaxEven;
                freqFirstMaxEven = freqEven[i];
                firstMaxEven = i;
            }
            else if (freqEven[i] > freqSecondMaxEven) {
                freqSecondMaxEven = freqEven[i];
                secondMaxEven = i;
            }
            if (freqOdd[i] >= freqFirstMaxOdd) {
                secondMaxOdd = firstMaxOdd;
                freqSecondMaxOdd = freqFirstMaxOdd;
                freqFirstMaxOdd = freqOdd[i];
                firstMaxOdd = i;
            }
            else if (freqOdd[i] > freqSecondMaxOdd) {
                freqSecondMaxOdd = freqOdd[i];
                secondMaxOdd = i;
            }
        }
        if (firstMaxEven != firstMaxOdd) {
            return length - freqFirstMaxEven - freqFirstMaxOdd;
        }
        return Math.min(length - freqFirstMaxEven - freqSecondMaxOdd, length - freqFirstMaxOdd - freqSecondMaxEven);
    }
}