class Encrypter {

    private Map<Character, String> enc;
    private Map<String, Integer> count;
    
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        enc = new HashMap<>();
        count = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            enc.put(keys[i], values[i]);
        }
        for (String word : dictionary) {
            String encryptWord = encrypt(word);
            count.put(encryptWord, count.getOrDefault(encryptWord, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            sb.append(enc.getOrDefault(word1.charAt(i), "#"));
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return count.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */