public int maxDistance(int[] n1, int[] n2) {
    int i = 0, j = 0, res = 0;
    while (i < n1.length && j < n2.length) {
        if (n1[i] > n2[j])
            ++i;
        else
            res = Math.max(res, j++ - i);
    }
    return res;
}
