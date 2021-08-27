/* 
My thought process:
Here when I looked onto the constraints, the length is given only 200, so we will be doing the problem with a small array and we can directly go on with the brute force O(n^3) soltuion. Trying all the possible combination and if it satisfies, increment the count.  The final count will be our answer.
The other solution is by using dynamic programming which will reduce the time complexity into O(n^2).
-> Create a dp array of length rating.length
-> Now we go from i=0->length and innner loop j=i->0
-> Now we just check for the condition rating[i] < rating[j] if yes,
                increment dp[i] by 1 and we update the count by adding with dp[j] (we add the DP[j] to count for all j < i such that rating[i] > rating[j] because we know that rating[j] is less than rating[i] and we also know that rating[j] is greater than DP[j] elements on it's left so they are also less than rating[i] hence they can form a combination.)
                
-> Now we have to reset our dp array because now we have to do the same for the other condition also. I initially didn't reset the dp array and got a wrong answer first, then I reset the array.
-> After reset do the same and update the count with dp[j]

Finally just return the count

/*


/*
class Solution {
    public int numTeams(int[] rating) {
		int length = rating.length;
		if (length == 1)
			return 0;
		int count = 0;
		for (int i=0; i<length-2; i++) {
			for (int j=i+1; j<length-1; j++) {
				for (int k=j+1; k<length; k++) {
					if ((rating[i]<rating[j] && rating[j]<rating[k]) || (rating[i]>rating[j] && rating[j]>rating[k]))
						count += 1;
				}
			}
		}
		return count;		        
    }
}
*/

class Solution {
	public int numTeams(int [] rating) {
		int length = rating.length;
		int [] dp = new int[length];
		int count = 0;
		for (int i=0; i<length; i++) {
			for (int j=i; j>=0; j--) {
				if (rating[i] < rating[j]) {
					dp[i] += 1;
					count += dp[j];
				}
			}
		}
		dp = new int[length];
		for (int i=0; i<length; i++) {
			for (int j=i; j>=0; j--) {
				if (rating[i] > rating[j]) {
					dp[i] += 1;
					count += dp[j];
				}
			}
		}
		return count;
    }
}



