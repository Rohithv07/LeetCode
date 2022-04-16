// If we buy cnt pens, we can buy up to (total - cnt * cost1) / cost2 + 1 pencils. We do plus one as we can also buy zero pencils.

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (cost1 > total && cost2 > total) {
            return 1;
        }
        long count = 0;
        int value = 0;
        for (int i = 0;;i++) {
            value = total - cost1 * i;
            if (value < 0) {
                break;
            }
            count += (long)(Math.floor((long) value / (long) cost2) + 1);
        }
        return count;
    }
}