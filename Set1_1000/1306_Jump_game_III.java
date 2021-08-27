class Solution {
    public boolean canReach(int[] arr, int start) {
        return bfs(arr, start);
    }
    public boolean bfs(int[] array, int start) {
        int n = array.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int num = queue.peek();
            queue.remove();
            if (array[num] == 0)
                return true;
            if (array[num] < 0)
                continue;
            if (num + array[num] < n)
                queue.offer(num+array[num]);
            if (num - array[num] >= 0)
                queue.offer(num - array[num]);
            array[num] = -array[num];
        }
        return false;
        }
    }

