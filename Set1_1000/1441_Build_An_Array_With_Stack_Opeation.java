class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j = 0;
        for (int i=1; i<=n && j<target.length; i++) {
                result.add("Push");
                if (i == target[j])
                    j += 1;
                else
                    result.add("Pop");
            }
        return result;
    }
}
