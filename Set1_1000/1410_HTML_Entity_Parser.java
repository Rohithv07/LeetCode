//"&amp;gt; here there occurs an error if we add & inside the map instead of separetely replacing

class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&apos;", "'");
        map.put("&quot;", "\"");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for (String key: map.keySet()) {
            text = text.replaceAll(key, map.get(key));
        }
        text = text.replaceAll("&amp;", "&");
        return text;
    }
}
