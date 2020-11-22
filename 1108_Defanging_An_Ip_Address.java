class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char letter: address.toCharArray()) {
            if (letter == '.') {
                sb.append('[');
                sb.append('.');
                sb.append(']');
            }
            else
                sb.append(letter);
        }
        return sb.toString();
    }
}
