class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int [] count = new int [26];
        for (String s : B) {
            int [] b = new int [26];
            for (char ch : s.toCharArray()) {
                b[ch - 'a'] += 1;
            }
            for (int i=0; i<26; i++) {
                count[i] = Math.max(count[i], b[i]);
            }
        }
        outer : for (String s: A) {
            int [] a = new int [26];
            for (char ch : s.toCharArray()) {
                a[ch - 'a'] += 1;
            }
            for (int i = 0; i<26; i++) {
                if (count[i] > a[i])
                    continue outer;
            }
            result.add(s);
        }
        return result;
    }
}
