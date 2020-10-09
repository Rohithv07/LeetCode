
class ProductOfNumbers {
    private List<Integer> storeNumber;
    private int product = 1;
    public ProductOfNumbers() {
        storeNumber = new ArrayList();
        product = 1;
    }
    
    public void add(int num) {
        if (num == 0) {
            storeNumber = new ArrayList<>();
            product = 1;
            return;
        }
        product *= num;
        storeNumber.add(product);
        
    }
    
    public int getProduct(int k) {
        int size = storeNumber.size();
        if (size < k)
            return 0;
        int answer = storeNumber.get(storeNumber.size()-1);
        if (storeNumber.size() == k)
            return answer;
        return (answer / storeNumber.get(size - k - 1));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
