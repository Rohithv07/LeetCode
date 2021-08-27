class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        List<List<Integer>> adjacent = new ArrayList<>(v);
        for (int i=0; i<numCourses; i++)
            adjacent.add(new LinkedList<>());
        for (int i=0; i<prerequisites.length; i++)
            adjacent.get(prerequisites[i][0]).add(prerequisites[i][1]);
        List<Integer> list = new ArrayList<>();
        boolean [] visited = new boolean[numCourses];
        boolean [] recursionStack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (isCycle(i, visited, recursionStack, numCourses, adjacent, list))
                return new int[0];
            }
        int [] result = new int[list.size()];  
        for (int i=0; !list.isEmpty(); i++)
            result[i] = list.remove(0);
        return result;
    }
    public boolean isCycle(int v, boolean [] visited, boolean [] recursionStack, int numCourses, List<List<Integer>> adjacent,List<Integer> list){
        if (recursionStack[v])
            return true;
        if (visited[v])
            return false;
        visited[v]= true;
        recursionStack[v] = true;
        for (int child: adjacent.get(v)) {
            if (isCycle(child, visited, recursionStack, numCourses, adjacent, list))
                return true;
        }
        recursionStack[v] = false;
        list.add(v);
        return false;
    }
}
