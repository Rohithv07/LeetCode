class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.size() < n) {
            List<Integer> temporary = new ArrayList<>();
            for (int number : result) {
                if (number * 2 - 1 <= n)
                    temporary.add(number * 2 - 1);
            }
            for (int number : result) {
                if (number * 2 <= n)
                    temporary.add(number * 2);
            }
            result = temporary;
        }
        int [] beautiful = new int [n];
        int index = 0;
        for (int number : result) {
            beautiful[index++] = number;
        }
        return beautiful;
    }
}