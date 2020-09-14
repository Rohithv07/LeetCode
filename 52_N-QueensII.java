class Solution {
    public int totalNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helperFunction(result, current, n, 0);
        return result.size();
    }
    public void helperFunction(List<List<Integer>> result, List<Integer> current, int n, int start) {
        if (start == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i=0; i<n; i++) {
            current.add(i);
            if (isValid(current)) {
                helperFunction(result, current, n, start+1);
            }
            current.remove(current.size()-1);
        }
    }
    public boolean isValid(List<Integer> current) {
        int rowId = current.size()-1;
        for (int i=0; i<rowId; i++) {
            int diff = Math.abs(current.get(i) - current.get(rowId));
            if (diff == 0 || diff == rowId-i)
                return false;
        }
        return true;
    }
}
