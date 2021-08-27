class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> firstRow = new ArrayList();
        firstRow.add(1);
        result.add(firstRow);
        for (int i=1; i<=rowIndex; i++){
            List<Integer> previous = result.get(i-1);
            List<Integer> currentRow = new ArrayList();
            currentRow.add(1);
            for (int j=1; j<i; j++){
                currentRow.add(previous.get(j-1) + previous.get(j));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
        return result.get(rowIndex);
    }
}
