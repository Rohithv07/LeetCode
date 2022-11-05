class Solution {
    public String oddString(String[] words) {
        Map<String, List<Integer>> track = new HashMap<>();
        int length = words.length;
        int commonLength = words[0].length() - 1;
        int answerIndex = -1;
        for (int i = 0; i < length; i++) {
            String currentWord = words[i];
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < commonLength + 1; j++) {
                char currentChar = currentWord.charAt(j);
                char previousChar = currentWord.charAt(j - 1);
                int pos1 = previousChar - 'a';
                int pos2 = currentChar - 'a';
                int diff = pos2 - pos1;
                sb.append("*").append(diff);
            }
            String key = sb.toString();
            if (track.containsKey(key)) {
                track.get(key).add(i);
            }
            else {
                track.computeIfAbsent(key, x -> new ArrayList<>()).add(i);
            }
        }
        for (String key : track.keySet()) {
            int size = track.get(key).size();
            if (size == 1) {
                answerIndex = track.get(key).get(0);
                break;
            }
        }
        return words[answerIndex];
    }
}