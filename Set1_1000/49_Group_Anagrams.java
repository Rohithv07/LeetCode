class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> result = new HashMap();
        int [] countAlphabets = new int[26];
        for (String s: strs){
            Arrays.fill(countAlphabets, 0);
            for (char character: s.toCharArray())
                countAlphabets[character - 'a'] ++;
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++){
                sb.append('*');
                sb.append(countAlphabets[i]);
            }
            String mapKey = sb.toString();
            if (!result.containsKey(mapKey))
                result.put(mapKey, new ArrayList());
            result.get(mapKey).add(s);
        }
        return new ArrayList(result.values());
    }
}

// some comments


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return result;
        // a map to know about the count of chars and matching list of words
        Map<String, List> map = new HashMap<>();
        int [] count = new int [26];
        for (String s : strs) {
            // initialising count array to 0 for every word
            Arrays.fill(count, 0);
            for (char ch : s.toCharArray()) {
                count[ch - 'a'] += 1;
            }
            StringBuilder sb = new StringBuilder();
            // creating a unique key appending * and count as the count will be same for anagrams
            for (int i=0; i<26; i++) {
                sb.append("*");
                sb.append(count[i]);
            }
            String key = sb.toString();
            // if the key not present, we put it into the map and create an emoty list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // we getr the key and add the string
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
