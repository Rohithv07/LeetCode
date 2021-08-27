class Solution {
    public String customSortString(String order, String str) {
        if (order == null || order.length() == 0)
            return str;
        if (str == null || str.length() == 0)
            return "";
        int [] count = new int [26];
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        // order based on the relative of order
        for (char ch : order.toCharArray()) {
            while (count[ch - 'a']-- > 0) {
                sb.append(ch);
            }
        }
        // there might be some letters left in str that is untracked
        for (char ch='a'; ch<='z'; ch++) {
            while (count[ch - 'a']-- > 0)
                sb.append(ch);
        }
        return sb.toString();
    }
}