class Solution {
    Map<String, String> root;
    Map<String, Double> dist;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // key = root, value = parent  root/parent = values
        root = new HashMap<>();
        // key = root value = dist; 
        // example:
        //    a/c = a/b * b/c = dist.get(a) * dist.get(b); 
        dist = new HashMap<>();
        // construct the hashmap
        for(int i=0; i<equations.size(); i++){
            List<String> equation = equations.get(i);
            // find parent of according factor
            // for example: (a, b) -> (2.0)    x,y are the parent of a,b accordingly
            //   we know a/x = dist(a)    b/y = dist(b)  a/b =values[i] to get x/y = (b/y) * (a/b) / (a/x) = dist(b)*values[i] / dist(a)
            String s = find(equation.get(0));
            String p = find(equation.get(1));
            root.put(s, p);
            dist.put(s, dist.get(equation.get(1)) * values[i]/ dist.get(equation.get(0)));
        }
        
        double[] res = new double[queries.size()];
        
        //after constructing all root and dist graph
        for(int j=0; j<queries.size(); j++){
            List<String> query = queries.get(j);
            if(!root.containsKey(query.get(0)) || !root.containsKey(query.get(1))){
                res[j] = -1.0;
            }else{
                String qs = find(query.get(0));
                String qp = find(query.get(1));
                if(!qs.equals(qp)) res[j] = -1;
                else{
                    // we have same parent p for all characters at this time. so we know qs/p = dist(qs) and qp/p = dist(qp). Hence, qs/qp = (qs/p)/(qp/p) = dist(qs) / dist(qp);
                    res[j] = dist.get(query.get(0)) / dist.get(query.get(1));
                }
            }
        }
        return res;
    }
	
    public String find(String s){
        if(!root.containsKey(s)){
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if(root.get(s).equals(s)) return s;
        String cur_p = root.get(s);
        String p = find(cur_p);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(cur_p));
        // p is the final parent;
        return p;
    }
}




// simple dfs

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // dfs, find a path between node and multiply everything bw nodes
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double [] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return result;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String q1, String q2, Set<String> visited) {
        if (!graph.containsKey(q1)) {
            return -1.0;
        }
        if (graph.get(q1).containsKey(q2)) {
            return graph.get(q1).get(q2);
        }
        visited.add(q1);
        for (Map.Entry<String, Double> children : graph.get(q1).entrySet()) {
            if (!visited.contains(children.getKey())) {
                double product = dfs(graph, children.getKey(), q2, visited);
                if (product != -1.0) {
                    return children.getValue() * product;
                }
            }
        }
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double [] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            String u = equation.get(0);
            String v = equation.get(1);
            double weight = values[index++];
            graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, weight);
            graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, 1 / weight);
        }
        return graph;
    }
}
