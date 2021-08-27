class OrderedStream {
    int pointer;
    String [] result;
    public OrderedStream(int n) {
        pointer = 0;
        result = new String [n];
    }
    
    public List<String> insert(int id, String value) {
        result[id - 1] = value;
        List<String> list = new ArrayList<>();
        while (pointer < result.length && result[pointer] != null) {
            list.add(result[pointer]);
            pointer += 1;
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */
