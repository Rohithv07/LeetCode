class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        switch (ruleKey) {
            case "type" :
                for (List<String> item : items) {
                    String t = item.get(0);
                    if (ruleValue.equals(t))
                        count += 1;
                }
                break;
            case "color" : 
                for (List<String> item : items) {
                    String c = item.get(1);
                    if (ruleValue.equals(c))
                        count += 1;
                }
                break;
            case "name" :
                for (List<String> item : items) {
                    String n = item.get(2);
                    if (ruleValue.equals(n))
                        count += 1;
                }
                break;
        }
        return count;
    }
}
