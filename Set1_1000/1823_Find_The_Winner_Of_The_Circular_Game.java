class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            queue.add(i + 1);
        }
        while (queue.size() > 1) {
            int delete = k - 1;
            while (delete > 0) {
                queue.add(queue.remove());
                delete -= 1;
            }
            queue.remove();
        }
        return queue.remove();
    }
}


// another answer
public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }
