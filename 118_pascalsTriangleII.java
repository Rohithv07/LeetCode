class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if (numRows == 0)
            return result;
        List<Integer> first_row = new ArrayList();
        first_row.add(1);
        result.add(first_row);
        for (int i=1; i<numRows; i++){
            List<Integer> previous = result.get(i-1);
            List<Integer> current_row = new ArrayList();
            current_row.add(1);
            for (int j=1; j<i; j++){
                current_row.add(previous.get(j-1) + previous.get(j));
            }
            current_row.add(1);
            result.add(current_row);
        }
        return result;
        
    }
}
