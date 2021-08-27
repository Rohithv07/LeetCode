class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        List<List<Integer>> adjacent;
        int v = numCourses;
        adjacent = new ArrayList<>(v);
        for (int i=0; i<numCourses; i++)
            adjacent.add(new LinkedList<>());
        for (int i=0; i<p.length; i++)
            adjacent.get(p[i][1]).add(p[i][0]);
        boolean [] visited = new boolean[numCourses];
        boolean [] recursionStack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (isCycle(i, visited, recursionStack, adjacent, numCourses))
                return false;
        }
        return true;
    }
    public boolean isCycle(int v, boolean [] visited, boolean [] recursionStack, List<List<Integer>> adjacent, int numCourses){
        if (recursionStack[v])
            return true;
        if (visited[v])
            return false;
        visited[v] = true;
        recursionStack[v] = true;
        List<Integer> children = adjacent.get(v);
        for (Integer child:children) {
            if (isCycle(child, visited, recursionStack, adjacent, numCourses))
                return true;
        }
        recursionStack[v] = false;
        return false;
    } 
}
