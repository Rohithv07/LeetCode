class ThroneInheritance {
    
    private String kingName;
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Boolean> dead = new HashMap<>();
    
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
    }
    
    public void birth(String parentName, String childName) {
        map.computeIfAbsent(parentName, x -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        dead.put(name, true);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        dfs(kingName, result);
        return result;
    }
    
    public void dfs(String name, List<String> result) {
        if (!dead.containsKey(name)) {
            result.add(name);
        }
        for (String child : map.getOrDefault(name, new ArrayList<>())) {
            dfs(child, result);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
