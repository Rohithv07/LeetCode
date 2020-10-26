// here first we can try the recursive approach
// here the first player wins if score(first) - score(second) >= 0

public boolean predictTheWinner(int [] nums) {
		return getWinner(nums, 0, nums.length-1) >= 0;
	}
	public int getWinner(int [] nums, int start, int end) {
		if (start == end)
			return nums[end];
		int fromFirst = nums[start] - getWinner(nums, start+1, end);
		int fromSecond = nums[end] - getWinner(nums, start, end-1);
		return Math.max(fromFirst, fromSecond);
	}
// O(2^n) and we can do better by saving the states that repeated here again and again
// so we can make use of dynamic programming
// we can make use of the 1d dp array with diagonals initialise with correponding index value from nums
// We may use only one dimensional dp[i] and we start to fill the table at the bottom right corner where dp[4] = nums[4]. On the next step, we start to fill the second to the last line, where it starts from dp[3] = nums[3]. Then dp[4] = Math.max(nums[4] - dp[3], nums[3] - dp[4]). Then we fill the third to the last line where dp[2] = nums[2] and so on... Eventually after we fill the first line and after the filling, dp[4] will be the answer.

public boolean predictTheWinner(int [] nums) {
	if (nums.length == 0)
		return true;
	if (nums.length % 2 == 0)
		return true;
	int length = nums.length;
	int [] dp = new int [length];
	for (int i=length-1; i>=0; i--) {
		for (int j=i; i<length; j++) {
			if (i == j)
				dp[i] = nums[i];
			else
				dp[i] = Math.max(nums[i] - dp[j], nums[j] - dp[j-1]);
		}
	}
	return dp[length-1] >= 0;
}
