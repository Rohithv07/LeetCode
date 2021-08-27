// my first approach not optimised
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int [][]{};
        List<List<Integer>> result = new ArrayList<>();
        for (int [] first: firstList) {
            for (int [] second: secondList) {
                List<Integer> current = new ArrayList<>();
                int firstStart = first[0];
                int firstEnd = first[1];
                int secondStart = second[0];
                int secondEnd = second[1];
                int low = Math.max(firstStart, secondStart);
                int high = Math.min(firstEnd, secondEnd);
                if (low <= high) {
                    current.add(low);
                    current.add(high);
                    result.add(current);
                }
                
            }
        }
        int [][] finalResult = new int [result.size()][2];
        int index = 0;
        for (List<Integer> list : result) {
            finalResult[index][0] = list.get(0);
            finalResult[index][1] = list.get(1);
            index++;
        }
        return finalResult;
        
    }
}



// optimised
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int [][]{};
        List<int []> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];
            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];
            if (firstEnd < secondEnd) {
                i += 1;
            }
            else {
                j += 1;
            }
            int low = Math.max(firstStart, secondStart);
            int high = Math.min(firstEnd, secondEnd);
            if (low <= high) {
                result.add(new int [] {low, high});
            }
        }
        return result.toArray(new int [result.size()][2]);
    }
}
