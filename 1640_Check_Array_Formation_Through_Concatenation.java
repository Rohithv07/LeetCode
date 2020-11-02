class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // add all the elements of arr with the index to a map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
        }
        // iterate through the pieces and check if they are not present or not alos the index
        for (int [] p: pieces) {
            // if the p[0] not in map, return false
            if (!map.containsKey(p[0]))
                return false;
            int index = map.get(p[0]);
            for (int i=1; i<p.length; i++) {
                // check for presence and disorder
                if (!map.containsKey(p[i]) || map.get(p[i]) != index+1)
                    return false;
                index += 1;
            }
        }
        return true;
    }
}