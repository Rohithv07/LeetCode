class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        boolean [] visited = new boolean[n];
        visited[id] = true;
        // bfs
        while (level-- > 0) {
            int size = queue.size();
            while (size-- > 0) {
                for (int friend: friends[queue.poll()]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
        }
        // now get the frequenecy using hashmap
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            for (String s: watchedVideos.get(queue.poll()))
                map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>(map.keySet());
        // now we need to sort them using a compartor
        result.sort((a, b) -> {
            int first = map.get(a);
            int second = map.get(b);
            if (first != second)
                return first - second;
            else
                return a.compareTo(b);
        });
        return result;
    }
}
