class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        a_pointer = 0
        b_pointer = 0
        maximum_length = 0
        hash_set = set()
        
        while(b_pointer < len(s)):
            if not s[b_pointer] in hash_set:
                hash_set.add(s[b_pointer])
                b_pointer += 1
                maximum_length = max(len(hash_set), maximum_length)
                
            else:
                hash_set.remove(s[a_pointer])
                a_pointer += 1
                
        
        return maximum_length
