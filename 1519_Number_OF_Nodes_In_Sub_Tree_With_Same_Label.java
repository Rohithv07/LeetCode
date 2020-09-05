Solution 1:

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int [] frequency = new int [n];
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i=0; i<n; i++)
            adjacent.add(new LinkedList<>());
        for (int [] edge: edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        boolean visited [] = new boolean[n];
        DFSHelper(0, visited, labels, adjacent, frequency);
        return frequency;
    }
    public int [] DFSHelper(int v, boolean [] visited, String labels, List<List<Integer>> adjacent, int [] frequency) {
        visited[v] = true;
        int [] countLabel = new int [26];
        List<Integer> children = adjacent.get(v);
        int index = labels.charAt(v) - 'a';
        for (Integer child: children) {
            if (!visited[child]) {
                int [] childCount = DFSHelper(child, visited, labels, adjacent, frequency);
                for (int i=0; i<26; i++) {
                countLabel[i] += childCount[i];
            }
            }
        }
        countLabel[index] += 1;
        frequency[v] = countLabel[index];
        return countLabel;
    }
}

Solution 2:

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int [] frequency = new int [n];
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i=0; i<n; i++)
            adjacent.add(new ArrayList<>());
        for (int [] edge: edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        boolean visited [] = new boolean[n];
        DFSHelper(0, visited, labels, adjacent, frequency);
        return frequency;
    }
    public int [] DFSHelper(int v, boolean [] visited, String labels, List<List<Integer>> adjacent, int [] frequency) {
        visited[v] = true;
        int [] countLabel = new int [26];
        List<int[]> children = new ArrayList<>();
        int index = labels.charAt(v) - 'a';
        for (int child: adjacent.get(v)) {
            if (!visited[child]) {
                children.add(DFSHelper(child, visited, labels, adjacent, frequency));
            }
        }
        for (int [] child: children) {
            for (int i=0; i<26; i++) {
                countLabel[i] += child[i];
            }
        }
        countLabel[index] ++;
        frequency[v] = countLabel[index];
        return countLabel;
    }
}
