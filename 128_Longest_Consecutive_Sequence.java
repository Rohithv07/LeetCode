class Solution {
	public int longestConsecutive(int[] nums) {
        int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int number: nums) {
			if (!map.containsKey(number)) {
				int left = (map.containsKey(number-1)) ? map.get(number-1) : 0;
				int right = (map.containsKey(number+1)) ? map.get(number + 1): 0;
				int sum = left + right + 1;
				map.put(number, sum);
				res = Math.max(res, sum);
				map.put(number-left, sum);
				map.put(number+right, sum);
			}
		}
		return res;
	}
}



// using hashset

int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            set.add(number);
        }
        for (int number : nums) {
            int left = number - 1;
            int right = number + 1;
            while (set.remove(left))
                left--;
            while (set.remove(right))
                right ++;
            result = Math.max(result, right - left - 1);
            if (set.isEmpty())
                return result;
        }
        return result;
