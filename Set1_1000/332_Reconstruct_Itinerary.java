class Solution {
    HashMap<String, PriorityQueue<String>> adjacent = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        if (tickets.size() == 0){
            return result;
        }
        for (List<String> ticket: tickets) {
            adjacent.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
            adjacent.get(ticket.get(0)).add(ticket.get(1));
        }
        if (!adjacent.containsKey("JFK"))
            return result;
        dfs("JFK", result);
        return result;
    }
    public void dfs(String from, List<String> result) {
        PriorityQueue<String> children = adjacent.get(from);
        while (children != null && !children.isEmpty()) 
            dfs(children.poll(), result);
        result.add(0, from);
    }
}
