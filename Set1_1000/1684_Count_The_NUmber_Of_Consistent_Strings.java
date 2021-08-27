class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char ch: allowed.toCharArray())
            set.add(ch);
        int count = 0;
        for (String word: words) {
            int flag = 0;
            for (char ch : word.toCharArray()) {
                if (set.contains(ch))
                    flag = 1;
                else {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                count += 1;
        }
        return count;
    }
}
