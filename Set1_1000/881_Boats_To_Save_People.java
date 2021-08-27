// so we are given with some weights and the limit of the life boat. we need to return the min number of boat required so that we ensure safty of all the passengers.
// the condition is that we can carry atmost 2 people in boat and it has to be <= limit.
// one of the solution will be taking each and every possible pairs and finding whether the pair weight <= limit.
// so we require nested loops to go through the array on the outer loop + inner loop goes from next elemnt to the end.
// so the time complexity will be O(n^2) where n = size of the array.

// Brute Force but wrong
public class Solution {
	public int numRescueBoats(int [] weights, int limit) {
		int length = weights.length;
		int count = 0;
		// outer loop
		for (int i=0; i<length; i++) {
			// inner loop starting from i+1
			for (int j=i+1; j<length; j++) {
				int sum = weights[i] + weights[j];
				if (sum <= limit)
					count += 1;
				
			}
		}
		return count;
	}
}


// but this solution gives only about the pair but doesn't look for a single element if left out and is <= limit.
// the other possivle solution may be doing a greedy approach.
// only considering the elements sum <= limit and doing a pointer based approach
// lets do a sort so that the heaviest person comes to the end and lightest person comes to the first.
// if we take a heavy + light weights and its <= limit, then we can count them.
// else we give single boat for the heavy.

// for sorting -> O(nlogn) + traversing through the array O(n/2) = O(n) so total O(nlogn)

public class Solution {
	public int numRescueBoats(int [] weights, int limit) {
		Arrays.sort(weights);
		int length = weights.length.
		int answer = 0;
		// we take left pointer as 0th index
		int left = 0;
		// right as last index
		int right = length - 1;
		// we traverse while left <= right
		while (left <= right) {
			answer += 1;
			if (weights[left] + weights[right] <= limit)
				// now we increment our left pointer
				left += 1;
			j -= 1;
		}
		return answer;	
	}
}
