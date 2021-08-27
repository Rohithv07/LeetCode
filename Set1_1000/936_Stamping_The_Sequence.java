// go from the target to *******.. Do the reverse process


class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char [] s = stamp.toCharArray();
        char [] t = target.toCharArray();
        List<Integer> track = new ArrayList<>();
        int stampLength = stamp.length();
        int targetLength = target.length();
        boolean [] visited = new boolean [targetLength];
        int starCount = 0;
        while (starCount < targetLength) {  
            boolean replace = false;
            for (int i=0; i<=targetLength - stampLength; i++) {
                if (!visited[i] && isPossibleToReplace(t, i, s)) {
                    starCount = continueReplace(t, i, stampLength, starCount);
                    visited[i] = true;
                    replace = true;
                    track.add(i);
                    if (starCount == targetLength)
                        break;
                }
            }
            if (!replace) {
                return new int [0];
            }
        }
        Collections.reverse(track);
        int [] result = new int [track.size()];
        for (int i=0; i<track.size(); i++) {
            result[i] = track.get(i);
        }
        return result;
    }
    
    public boolean isPossibleToReplace(char [] t, int key, char [] s) {
        for (int i=0; i<s.length; i++) {
            if (t[i + key] != '*' && t[i + key] != s[i])
                return false;
        }
        return true;
    }
    
    public int continueReplace(char [] t, int start, int end, int starCount) {
        for (int i=0; i<end; i++) {
            if (t[i + start] != '*') {
                t[i + start] = '*';
                starCount += 1;
            }   
        }
        return starCount;
    }
}
