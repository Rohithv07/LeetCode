// https://youtu.be/wT7gcXLYoao

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> store = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<n; i++) {
            fact *= i;
            store.add(i);
        }
        store.add(n);
        k = k - 1;
        while (true) {
            sb.append(store.get(k / fact));
            store.remove(k / fact);
            if (store.size() == 0) {
                break;
            }
            k %= fact;
            fact = fact / store.size();
        }
        return sb.toString();
    }
}