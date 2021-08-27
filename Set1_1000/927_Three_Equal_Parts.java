// first we counted the number of ones and check if it can be divied to 3 parts
// next we traverse from back to front and find the index until the count of one == totalCountOne / 3
// this is the third part index
// now we find the firstend index and secondend index traversing through arr and checking the equalities and return firstend and secondend + 1 in an array

class Solution {
    public int[] threeEqualParts(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int []{-1, -1};
        int length = arr.length;
        // there must be equal ones
        int sumOfOne = 0;
        for (int number : arr) {
            if (number == 1)
                sumOfOne += 1;
        }
        if (sumOfOne % 3 != 0)
            return new int []{-1, -1};
        if (sumOfOne == 0)
            return new int []{0, 2};
        int thirdPartStartingIndex = 0;
        int count = 0;
        int part = sumOfOne / 3;
        // right to left
        for (int i=length - 1; i>=0; i--) {
            if (arr[i] == 1) {
                if (++count == part) {
                    thirdPartStartingIndex = i;
                    break;
                }
            }
        }
        int firstPartEndingIndex = findEndingIndex(arr, 0, thirdPartStartingIndex);
        if (firstPartEndingIndex < 0)
            return new int []{-1, -1};
        int secondPartEndingIndex = findEndingIndex(arr, firstPartEndingIndex+1, thirdPartStartingIndex);
        if (secondPartEndingIndex < 0)
            return new int[]{-1, -1};
        return new int []{firstPartEndingIndex, secondPartEndingIndex + 1};
    }
    
    public int findEndingIndex(int [] arr, int start, int end) {
        // moving start pointer until we see a 1
        while (arr[start] == 0)
            start += 1;
        while (end < arr.length) {
            if (arr[start] != arr[end])
                return -1;
            start += 1;
            end += 1;
        }
        return start - 1;
    }
}