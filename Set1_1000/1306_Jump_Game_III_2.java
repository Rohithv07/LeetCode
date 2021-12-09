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

// using dfs

class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int length = arr.length;
        boolean [] visited = new boolean [length];
        return dfs(arr, start, length, visited);
    }
    
    private boolean dfs(int [] arr, int position, int length, boolean [] visited) {
        if (position < 0 || position >= length || visited[position]) {
            return false;
        }
        if (arr[position] == 0) {
            return true;
        }
        visited[position] = true;
        return dfs(arr, position + arr[position], length, visited) || dfs(arr, position - arr[position], length, visited);
    }
}
