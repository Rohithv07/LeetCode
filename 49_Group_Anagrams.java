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
