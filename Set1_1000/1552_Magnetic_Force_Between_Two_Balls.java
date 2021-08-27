class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 0;
        int right = position[n-1] - position[0];
        while (left < right) {
            int middle = right - (right - left) / 2;
            if (countDistance(middle, position, n) >= m)
              left = middle;
            else
                right = middle - 1;
        }
        return left;
    }
    public int countDistance(int min, int [] position, int n) {
        int answer = 1;
        int current = position[0];
        for (int i=1; i<n; i++) {
            if (position[i]-current >= min) {
                answer += 1;
                current = position[i];
            }
        }
        return answer;
    }
}
