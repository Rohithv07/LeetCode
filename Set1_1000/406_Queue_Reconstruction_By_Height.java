// https://youtu.be/khddrw6Bfyw

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0)
            return new int [][]{};
        int length = people.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p2[0], p1[0])); 
        // sort based on height decreasing, if height equal, sort based on smallest index
        for (int [] p : people) {
            result.add(p[1], p);  // this is add(index, value), after we insert to same position in the list, the previous value drops down the index
        }
        for (int [] value : result) {
            System.out.println(value[0] + " " + value[1]);
        }
        return result.toArray(new int [length][2]);
    }
}