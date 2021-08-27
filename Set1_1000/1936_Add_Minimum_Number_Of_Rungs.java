// we need just (current - previous - 1) / dist rungs
class Solution {
    public int addRungs(int[] rungs, int dist) {
        if (rungs == null || rungs.length == 0)
            return 0;
        int previous = 0;
        int count = 0;
        for (int number : rungs) {
            int diff = number - previous;
            count += (diff - 1) / dist;
            previous = number;
        }
        return count;
    }
}