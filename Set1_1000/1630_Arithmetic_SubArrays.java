class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i=0; i<l.length; i++) {
            List<Integer> inBetween = new ArrayList<>();
            int left = l[i];
            int right = r[i];
            for (int j=left; j<=right; j++)
                inBetween.add(nums[j]);
            result.add(isApplicable(inBetween));
        }
        return result;
    }
    public Boolean isApplicable(List<Integer>inBetween) {
        if (inBetween.size() < 2)
            return false;
        Collections.sort(inBetween);
        int mainDifference = inBetween.get(1) - inBetween.get(0);
        for (int i=1; i<inBetween.size() - 1; i++) {
            if (inBetween.get(i+1) - inBetween.get(i) != mainDifference)
                return false;
        }
        return true;
    }
} 
