class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<String> set = new HashSet<>();
        for (int [] d : dig) {
            set.add(d[0] + "-" + d[1]);
        }
        int count = 0;
        for (int [] artifact : artifacts) {
            boolean completed = true;
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!set.contains(i + "-" + j)) {
                        completed = false;
                        break;
                    }
                }
            }
            if (completed) {
                count++;
            }
        }
        return count;
    }
}