class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int a=1; a<bound; a *= x) {
            for (int b=1; a+b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1)
                    break;
            }
            if (x == 1)
                break;
        }
        return new ArrayList<>(set);
    }
}
