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

// without using hashmap

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder [] buildChar = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            buildChar[i] = new StringBuilder();
        }
        int directions = -1; // -1 denotes up directions and +1 denots down direction
        int rowIndex = 0;
        for (char ch : s.toCharArray()) {
            buildChar[rowIndex].append(ch);
            if (rowIndex == 0 || rowIndex == numRows - 1) {
                directions = 0 - directions;
            }
            rowIndex += directions;
        }
        for (int i=0; i<numRows; i++) {
            result.append(buildChar[i]);
        }
        return result.toString();
    }
}