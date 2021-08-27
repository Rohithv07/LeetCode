/* My thought Process
Here we need all the unique substrings, which means we need to use a hash set. Thats the first thing to do , select the proper DS.
Next we need to consider each of the substring and if its unique, then we add the element to the set and then carry on with the next substring.So backtracking can be used here.

So here we uses our handy backtracking format and we take each of the substring, then if that substring is not in set, then we add it into the set, then carry with the next substring.
At last if we reach a point which is equal to the length of string, then we just take the maximum of result or the size of the set as the answer.
Thats the whole problem.
*/

class Solution {
    int result = 0;
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        helper(s, 0, set);
        return result;
    }
    public void helper(String s, int start, Set<String> set) {
        if (start == s.length()) {
            result = Math.max(result, set.size());
            return;
        }
        for (int i=start; i<s.length(); i++) {
            String current = s.substring(start, i+1);
            if (!set.contains(current)) {
                set.add(current);
                helper(s, i+1, set);
                set.remove(current);
            }
        }
    }
}
