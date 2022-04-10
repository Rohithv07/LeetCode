class Solution {
    public int largestInteger(int num) {
        if (num < 10) {
            return num;
        }
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int store = num;
        while (store > 0) {
            int rem = store % 10;
            if (rem % 2 == 1) {
                odd.add(rem);
            }
            else {
                even.add(rem);
            }
            store /= 10;
        }
        int totalSize = odd.size() + even.size();
        Collections.sort(odd);
        Collections.sort(even);
        Collections.reverse(odd);
        Collections.reverse(even);
        StringBuilder sb = new StringBuilder();
        int oddIndex = 0;
        int evenIndex = 0;
        boolean [] order = new boolean [totalSize]; // false - odd true - even
        store = num;
        int last = totalSize - 1;
        while (store > 0) {
            int rem = store % 10;
            if (rem % 2 == 1) {
                order[last--] = false;
            }
            else {
                order[last--] = true;
            }
            store /= 10;
        }
        for (int i = 0; i < totalSize; i++) {
            if (order[i]) {
                sb.append(even.get(evenIndex++));
            }
            else {
                sb.append(odd.get(oddIndex++));
            }
        }
        String result = sb.toString();
        return Integer.valueOf(result);
    }
}