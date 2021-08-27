// https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/discuss/1375478/JavaC%2B%2BPython-Binary-Search-and-O(1)-Soluitons

class Solution {
    public long minimumPerimeter(long neededApples) {
        long low = 1l;
        long high = 100000l;
        while (low < high) {
            long middle = low + (high - low) / 2;
            if (middle * middle * middle * 4 + middle * middle * 6 + middle * 2 >= neededApples) {
                high = middle;
            }
            else {
                low = middle + 1;
            }
        }
        return low * 8;
    }
}