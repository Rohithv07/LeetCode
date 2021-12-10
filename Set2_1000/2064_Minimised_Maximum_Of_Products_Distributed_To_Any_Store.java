class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        if (quantities == null || quantities.length == 0) {
            return -1;
        }
        int low = 1;
        int high = findMax(quantities);
        return binarySearch(n, quantities, low, high);
    }
    
    public int binarySearch(int n, int [] quantities, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (canWeDistribute(quantities, n, middle)) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    public boolean canWeDistribute(int [] quantities, int n, int barrier) {
        int count = 0;
        for (int number : quantities) {
            count += (number + barrier - 1) / barrier;
            if (count > n) {
                return false;
            }
        }
        return true;
    }
    
    public int findMax(int [] nums) {
        int max = 0;
        for (int number : nums) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}