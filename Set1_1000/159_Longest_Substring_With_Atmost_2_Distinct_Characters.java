/*
This is a problem asked by Google.

Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
*/




public class Solution {
	public int longestSubstringWithAtmost2Characters(String s) {
		int start = 0;
		int end = 0;
		int counter = 0;
		int length = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (end < s.length()) {
			char chEnd = s.charAt(end);
			map.put(chEnd, map.getOrDefault(chEnd, 0) + 1);
			if (map.get(chEnd) == 1)  // a new character
				counter += 1;
			end += 1;
			while (counter > 2) {
				char chStart = s.charAt(start);
				map.put(chStart, map.get(chStart) - 1);
				if (map.get(chStart) == 0)
					counter -= 1;
				start += 1;
			}
			length = Math.max(length, end - start);
		}
		return length;
	}
}
