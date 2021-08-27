class Solution {
    public String freqAlphabets(String s) {
        Map<String, Character> map = new HashMap<>();
        int k = 1;
        for (char ch = 'a'; ch<='z'; ch++) {
            if (ch < 'j')
                map.put(String.valueOf(k++), ch);
            else
                map.put(String.valueOf(k++)+"#", ch);
        }
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                sb.append(map.get(s.substring(i-2, i+1)));
                i -= 3;
            }
            else {
                sb.append(map.get(s.substring(i, i+1)));
                i -= 1;
            }
        }
        return sb.reverse().toString();
    }
}
