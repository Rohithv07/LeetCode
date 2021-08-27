// 1. Add the numbers from i = 1 to m to linked list
// 2. Traverse throught the queries, get the current value, current value index at P, then remove it and add it to the first. Add the index to result

class Solution {
	public int[] processQueries(int[] queries, int m) {
        int [] result = new int [queries.length];
		// 1.
		LinkedList<Integer> P = new LinkedList<>();
		for (int i=1; i<=m; i++) {
			P.add(i);
		}
		// 2.
		for (int i=0; i<queries.length; i++) {
			int val = queries[i];
			int index = P.indexOf(val);
			int vals = P.get(index);
			P.remove(index);
			P.addFirst(vals);
			result[i] = index;
		}
		return result;
		
   	}
}
