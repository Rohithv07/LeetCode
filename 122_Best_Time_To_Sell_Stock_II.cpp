class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max_without_stock = 0, max_with_stock = -10000;
        for(int i: prices){
            max_with_stock = max(max_with_stock, max_without_stock - i);
            max_without_stock = max(max_without_stock, max_with_stock + i);
        }
        return max_without_stock;
    }
};
