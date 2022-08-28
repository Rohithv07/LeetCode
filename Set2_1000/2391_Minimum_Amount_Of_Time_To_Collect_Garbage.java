
// we need to have the minimum number of time to collect garbage
// we can either visit all hose, or not visit every house
// so we are only concerned about the very last garbage pos of each type

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int plastic = 0;
        int glass = 0;
        int metal = 0;
        int minuteCost = 0;
        for (int i = 0; i < garbage.length; i++) {
            String g = garbage[i];
            // find the last index for each metal, plastic, glass
            for (char ch : g.toCharArray()) {
                if (ch == 'P') {
                    plastic = i;
                }
                else if (ch == 'M') {
                    metal = i;
                }
                else {
                    glass = i;
                }
                // each pickup cost a time of 1 min
                minuteCost++;
            }
        }
        // take the prefixSum and consider the last time from it
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        minuteCost += plastic == 0 ? 0 : travel[plastic - 1];
        minuteCost += glass == 0 ? 0  : travel[glass - 1];
        minuteCost += metal == 0 ? 0 : travel[metal - 1];
        return minuteCost;
    }
}