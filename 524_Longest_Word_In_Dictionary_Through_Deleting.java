class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            int i = 0;
            for (char ch : s.toCharArray()) {
                if (i < word.length() && ch == word.charAt(i))
                    i += 1;
            }
            if (i == word.length() && word.length() >= result.length()) {
                if (word.length() > result.length() || word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }
        return result;
    }
}



class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0)
            return "";
        int index = -1;
        int max = 0;
        Collections.sort(dictionary); // O(sizelogsize)
        for (int i=0; i<dictionary.size(); i++) { // O(sizeOfDictiaonry)
            String current = dictionary.get(i); // O(n + max(wordslkengthindict))
            if (isSubsequence(s, current)) {
                int length = current.length();
                if (length > max) {
                    max = length;
                    index = i;
                }
            }
        }
        return index == -1 ? "" : dictionary.get(index);
    }
    
    public boolean isSubsequence(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return j == length2 ? true : false;
    }
}

// inorder to optimise, we can remove sorting and use compareTo in java


class Solution {
    public String findLongestWord(String s, List<String> d) {
    String longest = "";
    for (String dictWord : d) {
        int i = 0;
        for (char c : s.toCharArray()) 
            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

        if (i == dictWord.length() && dictWord.length() >= longest.length()) 
            if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                longest = dictWord;
    }
    return longest;
}
}

