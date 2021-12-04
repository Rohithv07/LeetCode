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


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(result, current, candidates, target, 0, 0);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> current, int [] candidates, int target, int currentSum, int position) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=position; i<candidates.length; i++) {
            if (i > position && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (currentSum + candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target, currentSum + candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}