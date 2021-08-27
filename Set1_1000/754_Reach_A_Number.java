class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        if (target % 2 == 0)
            return k;
        return k + 1 + k % 2;
    }
}
