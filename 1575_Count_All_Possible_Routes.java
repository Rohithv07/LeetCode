class Solution {
	private int mod = (int) 1e9 + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int length = locations.length;
        long [][] dp = new long[length][fuel + 1]; // number of times we reach a city with fuel
        // fill with -1 to make sure it is unvisited or visited.
        for (int i=0; i<length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // count recursively in top down manner
        return (int) helper(locations, start, finish, fuel, dp);        
    }
	public long helper(int [] locations, int currentCity, int end, int fuel, long [][] dp) {
		// fuels dries out, return 0
		if (fuel < 0)
			return 0;
		// also we have visited the city earlier
		if (dp[currentCity][fuel] != -1)
			return dp[currentCity][fuel];
		// we increment if we reach at end
		long answer = (currentCity == end) ? 1 : 0;
		// check for other possibilites and do not stop here
		for (int otherLocations=0; otherLocations<locations.length; otherLocations++) {
            if (otherLocations != currentCity)
                // recursive call the function with updated value of fuel and increment the answer with respective value
            answer = (answer + helper(locations, otherLocations, end, fuel - Math.abs(locations[currentCity] - locations[otherLocations]), dp)) % mod;
         }
        return dp[currentCity][fuel] = answer;
        } 
}

