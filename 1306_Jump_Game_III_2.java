class Solution {
    public boolean canReach(int[] arr, int start) {
        int length = arr.length;
        boolean [] visited = new boolean [length];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentIndex = queue.poll();
                visited[currentIndex] = true;
                if (arr[currentIndex] == 0)
                    return true;
                if (currentIndex + arr[currentIndex] < length && !visited[currentIndex + arr[currentIndex]])
                    queue.offer(currentIndex + arr[currentIndex]);
                if (currentIndex - arr[currentIndex] >= 0 && !visited[currentIndex - arr[currentIndex]]) 
                    queue.offer(currentIndex - arr[currentIndex]);
            }
        }
        return false;
    }
}
