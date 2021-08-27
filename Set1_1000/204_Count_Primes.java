class Solution {
    public int countPrimes(int n) {
        boolean [] prime = new boolean[n];
        int primeCount = 0;
        for (int i=2; i*i<prime.length; i++){
            if (!prime[i]){
                for (int j=2; j*i<prime.length; j++)
                    prime[i*j] = true;
            }
        }
        for (int i=2; i<prime.length; i++){
            if (!prime[i])
                primeCount ++;
        }
        return primeCount;
    }
}
