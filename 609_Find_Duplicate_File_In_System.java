class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String [] s = path.split(" ");
            for (int i=1; i<s.length; i++) {
                int index = s[i].indexOf("(");
                String content = s[i].substring(index);
                String fileName = s[0] + "/" + s[i].substring(0, index);
                Set<String> fileNames = map.getOrDefault(content, new HashSet<>());
                fileNames.add(fileName);
                map.put(content, fileNames);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(new ArrayList<>(map.get(key)));
            }
        }
        return result;
    }
}

// follow - up : https://leetcode.com/problems/find-duplicate-file-in-system/discuss/104123/C%2B%2B-clean-solution-answers-to-follow-up 
