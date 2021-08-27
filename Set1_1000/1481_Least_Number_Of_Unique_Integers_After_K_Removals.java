/*
My thought process
-> Here I used a hashmap to store the frequencies of each number in the given array.
-> Then moved the keys onto the list and sort based on the count using a lambda.
        // basic template to sort ((a, b) -> map.get(a) - map.get(b));
-> Now we consider removing the smallest count leaving the largest count numbers and returning the size of mapSize - count.
*/


class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr.length < k)
            return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number: arr) {
            if (map.containsKey(number))                     // whole statement similar to map.getOrDefault(n, 0) + 1;
                map.replace(number, map.get(number) + 1);
            else 
                map.put(number, 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(a) - map.get(b));
        int i=0;
        while (k>0 && i<map.size()) {
            k -= map.get(list.get(i));
            if (k >= 0)
                count += 1;
            i++;
        }
        
        
        return map.size() - count;
    }
}
