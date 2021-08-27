// we can make use of a hashset
// lets check the double of the element inside the set and return true, if we find one.
// else we add it into the set for later checking
// if we gets out of the loop, return false

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int number: arr) {
            if (set.contains(number * 2) || (number%2 == 0 && set.contains(number / 2)))
                return true;
            set.add(number);
        }
        return false;
    }
}
