class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs.length == 0)
           return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String smallerString = strs[0];
        String largerString = strs[strs.length - 1];
        int i = 0;
        int j = 0;
        while (i < smallerString.length() && j < largerString.length()) {
            if (smallerString.charAt(i) == largerString.charAt(j)) {
                sb.append(smallerString.charAt(i));
            }
            else {
                return sb.toString();
            }
            i++; j++;
        }
        return sb.toString();
    }
}
