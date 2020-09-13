/*

Accepted Python Solution
def grayCode(self, n):
        results = [0]
        for i in range(n):
            results += [x + pow(2, i) for x in reversed(results)]
        return results
*/

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0)
            return result;
        int increase = 1;
        for (int i=0; i<n; i++) {
            int size = result.size();
            for (int j=size-1; j>=0; j--) {
                result.add(result.get(j) + increase);
            }
            increase = increase * 2;
        }
        return result;
    }
}
