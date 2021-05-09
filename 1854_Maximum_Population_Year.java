class Solution {
    public int maximumPopulation(int[][] logs) {
        int length = logs.length;
        int [] map = new int [101];
        for (int [] log : logs) {
            for (int i=log[0]; i<log[1]; i++) {
                map[i - 1950] += 1;
            }
        }
        int result = -1;
        int maximum = 0;
        for (int i=0; i<map.length; i++) {
            if (maximum < map[i]) {
                maximum = map[i];
                result = i + 1950;
            }
        }
        return result;
    }
}
