class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap();
        boolean increment = true;
        int pos = 0;
        for (char c: s.toCharArray()){
            if (pos == numRows)
                increment = false;
            if (pos == 1)
                increment = true;
            if (increment)
                pos += 1;
            else
                pos -= 1;
            while(!map.containsKey(pos)){
                map.put(pos, new StringBuilder());
            }
            map.get(pos).append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int index: map.keySet()){
            result.append(map.get(index));
        }
        return result.toString();
    }
}
