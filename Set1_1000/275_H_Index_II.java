// find max value m such that you have atleast m numbers >= m and n - m numbers <= m
// https://youtu.be/CjKJDloMnwE

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return -1;
        int length = citations.length;
        int left = 0;
        int right = length - 1;
        int result = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (citations[middle] == (citations.length - middle)) {
                return citations[middle];
            }
            else if (citations[middle] >  (length - middle)){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return length - left;
    }
}