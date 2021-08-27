class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> burgers = new ArrayList<>();
        // here we have to solve 4x+2y = tomatoSlices and x + y = cheeseSlice where x = jumbo and y = small
        // further simplification gives result as 2x = tomato - 2 * cheese and y = cheese - x
        int variable = (tomatoSlices - 2 * cheeseSlices);
        if (variable % 2 != 0 || variable < 0) {
            return burgers;
        }
        int jumbo = variable / 2;
        int small = cheeseSlices - jumbo;
        if (small < 0) {
            return burgers;
        }
        burgers.add(jumbo);
        burgers.add(small);
        return burgers;
    }
}
