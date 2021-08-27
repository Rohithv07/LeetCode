/*
we transverse the input for two times
first time, we add all the cities on the left side to a set
second time, we check if the city is in set, if not we add the right side to the result string and break.
result will be the city left in the set
*/
class Solution {
    public String destCity(List<List<String>> paths) {
        String result = "";
        Set<String> set = new HashSet<>();
        // 1st pass - add left side cities
        for (int i=0; i<paths.size(); i++) {
            set.add(paths.get(i).get(0));
        }
        // 2nd pass - whetehr the right side cities  on the set.
        for (int i=0; i<paths.size(); i++) {
            if (!set.contains(paths.get(i).get(1))) {
                result += paths.get(i).get(1);
                break;
            }     
        }
        return result;
    }
}
