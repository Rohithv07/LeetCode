class Solution {
    private Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        int length = expression.length();
        List<Integer> result = new ArrayList<>();
        if (expression == null || length == 0)
            return result;
        if (map.containsKey(expression))
            return map.get(expression);
        for (int i=0; i<length; i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String operator1 = expression.substring(0, i);
                String operator2 = expression.substring(i+1);
                List<Integer> divide1 = diffWaysToCompute(operator1);
                List<Integer> divide2 = diffWaysToCompute(operator2);
                for (Integer num1 : divide1) {
                    for (Integer num2 : divide2) {
                        int arithmeticResult = 0;
                        if (ch == '+')
                            arithmeticResult = num1 + num2;
                        else if (ch == '-')
                            arithmeticResult = num1 - num2;
                        else if (ch == '*')
                            arithmeticResult = num1 * num2;
                        result.add(arithmeticResult);
                    }
                }
            }
        }
        if (result.size() == 0)
            result.add(Integer.valueOf(expression));
        map.put(expression, result);
        return result;
        
    }
}
