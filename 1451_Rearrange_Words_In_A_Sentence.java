/* 
My thought process
Here the idea is to sort each words based on the length and join them with the new first letter as uppercase.
*/

class Solution {
    public String arrangeWords(String text) {
        // 1. First lets make a string array with only lowercase and separated by space.
        String [] array = text.toLowerCase().split("\\s");
        // 2. Now sort the words based on their length.
        Arrays.sort(array, (a, b) -> a.length() - b.length());
        // 3. We have string.join() to join the string with a delimiter
        String result = String.join(" ", array);
        // 4. Now return the final string making the first character uppercase and concatenating the remaining string.
        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }
}
