class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        // create a map with the alphabet and the mapping
        Map<Character, String> morseCode = new HashMap<>();
        morseCode.put('a', ".-");
        morseCode.put('b', "-...");
        morseCode.put('c',"-.-.");
        morseCode.put('d',"-..");
        morseCode.put('e',".");
        morseCode.put('f',"..-.");
        morseCode.put('g',"--.");
        morseCode.put('h',"....");
        morseCode.put('i',"..");
        morseCode.put('j',".---");
        morseCode.put('k',"-.-");
        morseCode.put('l',".-..");
        morseCode.put('m',"--");
        morseCode.put('n',"-.");
        morseCode.put('o',"---");
        morseCode.put('p',".--.");
        morseCode.put('q',"--.-");
        morseCode.put('r',".-.");
        morseCode.put('s',"...");
        morseCode.put('t',"-");
        morseCode.put('u',"..-");
        morseCode.put('v',"...-");
        morseCode.put('w',".--");
        morseCode.put('x',"-..-");
        morseCode.put('y',"-.--");
        morseCode.put('z',"--..");
        // now we have the mapping and now we can go through each of the string and based on each character we can append the appropriate code using a stringbuilder and store it inside the hashset
        Set<String> set = new HashSet<>();
        for (String s: words) {
            StringBuilder sb = new StringBuilder();
            for (char ch: s.toCharArray()) {
                String code = morseCode.get(ch);
                sb.append(code);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
