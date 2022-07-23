class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int length = rolls.length;
        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int roll : rolls) {
            set.add(roll);
            if (set.size() == k) {
                result++;
                set.clear();
            }
        }
        return result;
    }
}