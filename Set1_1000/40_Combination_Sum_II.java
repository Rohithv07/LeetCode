class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        helperFunction(result, current, candidates, target, 0, 0);
        return result;
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int [] candidates, int target, int start, int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        int previous = -1;
        for (int i=start; i<candidates.length; i++) {
            if (previous != candidates[i]) {
            current.add(candidates[i]);
            helperFunction(result, current, candidates, target, i+1, sum + candidates[i]);
            current.remove(current.size()-1);
            previous = candidates[i];
            }
        }
    }
}
