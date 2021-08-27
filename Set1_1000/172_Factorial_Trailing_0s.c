int trailingZeroes(int n){
    int count = 0;
    while(n){
        n = n / 5;
        count = count + n;
    }
    return count;
}
