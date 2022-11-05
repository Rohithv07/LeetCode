// bruteforce
// best approach is to use trie to store all the dictionary words and then do one by one char match of query 

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        int [] queryTrack;
        int [] dictTrack;
        for (String query : queries) {
            for (String dict : dictionary) {
                if (dict.equals(query)) {
                    result.add(query);
                    break;
                }
                int diffCount = 0;
                for (int i = 0; i < query.length(); i++) {
                    char queryChar = query.charAt(i);
                    int dictChar = dict.charAt(i);
                    if (queryChar != dictChar) {
                        diffCount++;
                    }
                }
                if (diffCount <= 2) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
}