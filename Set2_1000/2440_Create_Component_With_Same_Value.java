There is an undirected tree with n nodes labeled from 0 to n - 1.

You are given a 0-indexed integer array nums of length n where nums[i] represents the value of the ith node. You are also given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

You are allowed to delete some edges, splitting the tree into multiple connected components. Let the value of a component be the sum of all nums[i] for which node i is in the component.

Return the maximum number of edges you can delete, such that every connected component in the tree has the same value.

 

Example 1:


Input: nums = [6,2,2,2,6], edges = [[0,1],[1,2],[1,3],[3,4]] 
Output: 2 
Explanation: The above figure shows how we can delete the edges [0,1] and [3,4]. The created components are nodes [0], [1,2,3] and [4]. The sum of the values in each component equals 6. It can be proven that no better deletion exists, so the answer is 2.
Example 2:

Input: nums = [2], edges = []
Output: 0
Explanation: There are no edges to be deleted.
 

Constraints:

1 <= n <= 2 * 104
nums.length == n
1 <= nums[i] <= 50
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
edges represents a valid tree.

class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        int length = nums.length;
        List<List<Integer>> graph = buildGraph(edges, length);
        int sum = 0;
        int maxValue = 0;
        for (int num : nums) {
            sum += num;
            maxValue = Math.max(maxValue, num);
        }
        int maxCount = sum / maxValue;
        if (sum % maxCount == 0 && maxCount == length) {
            return length - 1;
        }
        for (int k = maxCount; k > 1; k--) {
            // if divisor of k, then do the dfs
            if (sum % k == 0 && dfs(nums, graph, 0, -1, sum / k) == 0) {
                return k - 1;
            }
        }
        return 0;
    }
    
    private int dfs(int [] nums, List<List<Integer>> graph, int node, int parent, int divisor) {
        int currentSubtreeSum = nums[node];
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (parent != child) {
                currentSubtreeSum += dfs(nums, graph, child, node, divisor);
                if (currentSubtreeSum > divisor) {
                    return currentSubtreeSum;
                }
            }
        }
        return currentSubtreeSum == divisor ? 0 : currentSubtreeSum;
    }
    
    private List<List<Integer>> buildGraph(int [][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}