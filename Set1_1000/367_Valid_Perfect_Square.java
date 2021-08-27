class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int left = 1;
        int right = num;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == num) 
                return true;
            else if (middle * middle > num)
                right = (int)middle-1;
            else
                left = (int)middle + 1;
        }
        return false;
    }
}
