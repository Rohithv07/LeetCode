class Solution {
    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        int index = 0;
        while (index + 1 < length && arr[index] < arr[index+1]) 
            index += 1;
        if (index == 0 || index == length - 1) // we start increasing from first and decreasing to the last.
            return false;                      // but it can't be peak at first or last
        while (index + 1 < length && arr[index] > arr[index+1])
            index += 1;
        return index == length - 1;
    }
}
