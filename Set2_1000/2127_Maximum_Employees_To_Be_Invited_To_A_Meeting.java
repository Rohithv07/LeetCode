// using Kahns algorithm for topological sorting

class Solution {
   public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        boolean[] visit = new boolean[n];
       
        for(int i = 0; i < n; ++i) {
            int j = favorite[i]; 
            indegrees[j]++;
        }
       
       
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; ++i) 
        {
            if (indegrees[i] == 0) 
            {
                visit[i] = true;
                que.add(i);
            }
        }
       
       
        int[] dp = new int[n]; 
        while(!que.isEmpty()) {
            int i = que.poll();
            int j = favorite[i];
            dp[j] = Math.max(dp[j], dp[i] + 1);
            if (--indegrees[j] == 0) 
            {
                visit[j] = true;
                que.add(j);
            }
        }
       
        int res = 0; 
        int result = 0; 
        for(int i = 0; i < n; ++i) 
        {
            if (visit[i] == false) 
            {
                int length = 0;
                
                for(int j = i; visit[j] == false; j = favorite[j]) 
                {
                    visit[j] = true;
                    ++length;
                }
                
                if (length == 2) 
                {
                    result += 2 + dp[i] + dp[favorite[i]];
                } 
                else 
                {
                    res = Math.max(res, length);
                }
            }
        }
        return Math.max(res, result);
    }
}





// using dfs

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList());
        }
        for(int i = 0; i< n; i++){
            int fav = favorite[i];
            adj.get(fav).add(i);
        }
        int visited[] = new int[n];
        Arrays.fill(visited, -1);
        //case 1, where two nodes likes each other and there could be max path going across these two node.
        int res1= 0;
        for(int i =0; i< n;i++){
            if(visited[i] == 1)
                continue;
            if(i ==  favorite[favorite[i]]){
                //block path from going i to fav[i] and vice-versa
                visited[favorite[i]] = 1;
                visited[i] = 1;
                
                //get the maximum path from i to its likers
                int a = dfs(adj, visited, i);
                //get the maximum path from favorite[i] to its likers 
                int b = dfs(adj, visited, favorite[i]);
                
                res1 += a + b + 2;
            }
        }
        //case 2, maximum result from cycle
        int res2 = 0;
        Arrays.fill(visited, -1);
        for(int i = 0; i<n; i++){
            if(visited[i] ==1) continue;
           res2 = Math.max(res2,  dfs2(adj, visited, i, -1)[1]); 
        }    
        return Math.max(res1, res2);
    }
    //[{found=1/not found=0}, {depth}]
    private int[] dfs2(List<List<Integer>> adj, int[] visited, int u, int start){
        if(start == u){
            return new int[]{1, 0};
        }
        if(visited[u] == 1) return new int[]{0,0};
        visited[u] = 1;
        
        int res [] = new int[2];
        for(int v : adj.get(u)){
            int ret[] = dfs2(adj, visited, v, start==-1? u : start);
            if(ret[0] == 1){
              int depth = 1 + ret[1];
                res[1] = Math.max(depth, res[1]);
            }
            
            if(res[1] > 0){
                res[0] = 1; 
            }
        }
        
       if(res[1] == 0) return new int[]{0, 0};
       return res; 
    }
    
    private int dfs(List<List<Integer>> adj, int[] visited, int u){
        visited[u] =1;
        int d  =0;
        for(int v : adj.get(u)){
            if(visited[v] != 1){
                int res = 1 + dfs(adj, visited, v);
                d = Math.max(d, res);
            }
        }
        return d;
    }
}