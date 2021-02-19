class Solution {
    public String minRemoveToMakeValid(String s) {
        int openBracket = 0;
        StringBuilder sb = new StringBuilder();
        // going from front to last and removing the extra closing braces
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracket += 1;
            }
            else if (ch == ')') {
                if (openBracket == 0)
                    continue;
                openBracket -= 1;
            }
            sb.append(ch);
        }
        
        // now there can be some cases where there are extra opening braces at the end
        // like abcd((
        // so after above loop there will be this string as result
        // now we move backward and check openBracket count > 0 and skip them
        // finally reverse the finalResult and return
        
        StringBuilder result = new StringBuilder();
        for (int i=sb.length()-1; i>=0; i--) {
            if (sb.charAt(i) == '(' && openBracket-- > 0) 
                continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }
}
