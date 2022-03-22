class Solution {
    private int pointForBob = 0;
    private int [] bobArrows = new int [12];
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int length = aliceArrows.length;
        int [] bob = new int [length];
        // in my opninon we have two options to consider
        // we can either shoot at a section or, we can skip and continue to the next section
        // in hope of finding the optimal score
        // backtrack and try to find the optimal
        backtrack(aliceArrows, bob, 11, 0, numArrows); // we start from back
        return bobArrows;
    }
    
    public void backtrack(int [] alice, int [] bob, int pos, int currentMax, int arrows) {
        if (pos < 0 || arrows <= 0) {
            if (arrows > 0) {
                bob[0] += arrows;
            }
            if (currentMax > pointForBob) {
                // we found a better result with better score card
                // so copy that
                pointForBob = currentMax;
                bobArrows = bob.clone();
            }
            return;
        }
        
        // two options as said
        // consider the current section point and move onto the next one
        if (arrows >= alice[pos] + 1) {
            bob[pos] = alice[pos] + 1;
            backtrack(alice, bob, pos - 1, currentMax + pos, arrows - alice[pos] - 1);
            bob[pos] = 0;
        }
        // other option is to just skip our current choice
        backtrack(alice, bob, pos - 1, currentMax, arrows);
        bob[pos] = 0;
    }
}

// O(2 ^ 12)