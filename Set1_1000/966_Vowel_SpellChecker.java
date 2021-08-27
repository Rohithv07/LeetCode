class Solution {
    public String[] spellchecker(String[] wordList, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Map<String, String> capital = new HashMap<>();
        Map<String, String> noVowels = new HashMap<>();
        for (String word : wordList) {
            String lower = word.toLowerCase();
            String withoutVowels = lower.replaceAll("[aeiou]", "#");
            capital.putIfAbsent(lower, word);
            noVowels.putIfAbsent(withoutVowels, word);
        }
        for (int i=0; i<queries.length; i++) {
            if (set.contains(queries[i]))
                continue;
            String lower = queries[i].toLowerCase();
            String withoutVowels = lower.replaceAll("[aeiou]", "#");
            if (capital.containsKey(lower))
                queries[i] = capital.get(lower);
            else if (noVowels.containsKey(withoutVowels))
                queries[i] = noVowels.get(withoutVowels);
            else
                queries[i] = "";
        }
        return queries;
    }
}
