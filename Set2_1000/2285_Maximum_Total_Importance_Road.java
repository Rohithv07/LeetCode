// efficient one
   public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] r : roads) {
            ++degree[r[0]];
            ++degree[r[1]];
        }
        Arrays.sort(degree);
        long importance = 0;
        for (int i = 0; i < n; ++i) {
            importance += (i + 1L) * degree[i];
        }
        return importance;
    }

// coded during contest

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           graph.add(new ArrayList<>());
        }
        for (int [] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        for (int i = 0; i < n; i++) {
            graph.get(i).add(i);
        }
        int [] count = new int [n];
        System.out.println(graph);
        Collections.sort(graph, (l1, l2) -> Integer.compare(l2.size(), l1.size()));
        int score = n;
        for (int i = 0; i < n; i++) {
            List<Integer> current = graph.get(i);
            int last = current.get(current.size() - 1);
            count[last] = score;
            System.out.println(last + "->" + count[last]);
            score--;
        }long sum = 0;
        for (int [] road : roads) {
            sum += count[road[0]] + count[road[1]];
        }
        System.out.println(graph);
        return sum;
    }
}