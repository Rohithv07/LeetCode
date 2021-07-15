// more efficient solution

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;
        int [] count = new int [26];
        for (char ch : p.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        int left = 0;
        int right = 0;
        int resultLength = p.length();
        int length = s.length();
        int counter = 0;
        for (int number : count) {
            if (number != 0)
                counter ++;
        }
        while (right < length) {
            char current = s.charAt(right);
            count[current - 'a'] -= 1;
            if (count[current - 'a'] == 0)
                counter -= 1;
            right += 1;
            while (counter == 0) {
                char leftChar = s.charAt(left);
                count[leftChar - 'a'] += 1;
                if (count[leftChar - 'a'] > 0)
                    counter ++;
                if (right - left == resultLength) {
                    result.add(left);
                }
                left ++;
            }
        }
        return result;
    }
}



// 1 solution
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int length1 = s.length();
        int length2 = p.length();
        int [] count = new int [26];
        for (char ch : p.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (int i=0; i<=length1 - length2; i++) {
            String current = s.substring(i, i + length2);
            int [] tempCount = new int [26];
            for (char ch : current.toCharArray()) {
                tempCount[ch - 'a'] += 1;
            }
            boolean flag = true;
            for (int j=0; j<26; j++) {
                if (count[j] != tempCount[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                result.add(i);
        }
        return result;
    }
}

// 2 solution
public class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
}
