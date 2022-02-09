class Solution {
    public int findFinalValue(int[] nums, int original) {
        if (nums == null || nums.length == 0) {
            return original;
        }
        Set<Integer> track = new HashSet<>();
        for (int number : nums) {
            track.add(number);
        }
        if (!track.contains(original)) {
            return original;
        }
        while (track.contains(original)) {
            original <<= 1;
        }
        return original;
    }
}


class Solution {
    public int findFinalValue(int[] nums, int original) {
        // considering the constraints, we can make use of an array of size 1001
        if (nums == null || nums.length == 0) {
            return original;
        }
        boolean [] visited = new boolean [1001];
        for (int number : nums) {
            visited[number] = true;
        } 
        if (!visited[original]) {
            return original;
        }
        while (original <= 1000 && visited[original]) {
            original <<= 1;
        }
        return original;
    }
}