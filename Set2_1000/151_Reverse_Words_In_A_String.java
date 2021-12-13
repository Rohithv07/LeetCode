class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String [] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=split.length-1; i>=0; i--) {
            String current = split[i];
            if (!current.equals("")) {
                sb.append(current);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        String reversed = sb.toString();
        System.out.println(reversed);
        return reversed;
    }
}




class Solution {
    public String reverseWords(String s) {
        String str = reverse(s);
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String w = words[i];
            if(w.isBlank() || w.isEmpty()) continue;
            sb.append(reverse(w));
            if(i!=words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
    private String reverse(String s){
        StringBuilder str = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            str.append(c);
        }
        return str.toString();
    }
}