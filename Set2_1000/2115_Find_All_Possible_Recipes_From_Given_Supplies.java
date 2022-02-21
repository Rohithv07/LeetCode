class Solution {
    
    private static final int VISITED = 0;
    private static final int VISITING = 1;
    private static final int NOT_VISITED = 2;
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = buildGraph(recipes, ingredients);
        Map<String, Integer> visited = new HashMap<>();
        // can be a possible supply for some other recipe
        for (String recipe : recipes) {
            visited.put(recipe, NOT_VISITED);
        }
        for (String supply : supplies) {
            visited.put(supply, VISITED);
        }
        List<String> result = new ArrayList<>();
        for (String recipe : recipes) {
            dfs(recipe, graph, visited, result);
        }
        return result;
    }
    
    public boolean dfs(String recipe, Map<String, List<String>> graph, Map<String, Integer> visited, List<String> result) {
        if (!visited.containsKey(recipe)) {
            return false;
        }
        if (visited.get(recipe) == VISITING) {
            return false;
        }
        if (visited.get(recipe) == VISITED) {
            return true;
        }
        visited.put(recipe, VISITING);
        List<String> ingredient = graph.get(recipe);
        for (String ing : ingredient) {
            if (!dfs(ing, graph, visited, result)) {
                return false;
            }
        }
        visited.put(recipe, VISITED);
        result.add(recipe);
        return true;
    }
    
    public Map<String, List<String>> buildGraph(String [] recipes, List<List<String>> ingredients) {
        Map<String, List<String>> graph = new HashMap<>();
        int recipeLength = recipes.length;
        for (int i = 0; i < recipes.length; i++) {
            graph.put(recipes[i], ingredients.get(i));
        }
        return graph;
    }
}