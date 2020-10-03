class Solution {
    public List<String> stringMatching(String[] words) {
        int length = words.length;
        Set<String> set = new HashSet<>();
        for (int i=0; i<length; i++) {
            String currWord = words[i];
            for (int j=i+1; j<length; j++) {
                String nextWord = words[j];
                if (currWord.contains(nextWord))
                    set.add(nextWord);
                if (nextWord.contains(currWord))
                    set.add(currWord);
            }
        }
        List<String> result = new ArrayList<>(set); // convert set to list
        return result;
    }
}
