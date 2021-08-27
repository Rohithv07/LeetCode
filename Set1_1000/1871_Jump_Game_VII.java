class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int length = s.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i=1; i<length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - maxJump) {
                queue.poll();
            }
            if (s.charAt(i) == '0' && !queue.isEmpty() && queue.peek() <= i - minJump) {
                queue.offer(i);
                if (i == length - 1)
                    return true;
            }
        }
        return false;
    }
}
