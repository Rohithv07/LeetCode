class Solution {
    	public int sumFourDivisors(int[] nums) {
        	int sum = 0;
		for (int number: nums) {  // O(n)
			sum +=  findSumDivisor(number); // O(sqrt(n))
		}
		return sum;
	}
	public int findSumDivisor(int number) {
		int count = 0; // to count the number of divisors, here we only need to find until count = 2 as 1 and the number is already considered.
		int sum = number + 1; // as the number and 1 will be divissors
		for (int i=2; i*i<=number; i++) {
			if (n%i == 0) {
				if (n/i == i) 
					return 0; // only the number and 1 as divisors, so return 0
				else {
					sum += i + n / i;
					count += 2; 	
				}
			}
		}
		return count == 2 ? sum:0;
	}
}
