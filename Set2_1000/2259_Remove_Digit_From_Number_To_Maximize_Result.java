You are given a string number representing a positive integer and a character digit.

Return the resulting string after removing exactly one occurrence of digit from number such that the value of the resulting string in decimal form is maximized. The test cases are generated such that digit occurs at least once in number.

 

Example 1:

Input: number = "123", digit = "3"
Output: "12"
Explanation: There is only one '3' in "123". After removing '3', the result is "12".
Example 2:

Input: number = "1231", digit = "1"
Output: "231"
Explanation: We can remove the first '1' to get "231" or remove the second '1' to get "123".
Since 231 > 123, we return "231".
Example 3:

Input: number = "551", digit = "5"
Output: "51"
Explanation: We can remove either the first or second '5' from "551".
Both result in the string "51".
 

Constraints:

2 <= number.length <= 100
number consists of digits from '1' to '9'.
digit is a digit from '1' to '9'.
digit occurs at least once in number.


class Solution {
    public String removeDigit(String number, char digit) {
        int digitInNumber = digit - '0';
        int length = number.length();
        int lastOccurance = length - 1;
        for (int i = 0; i < length - 1; i++) {
            int current = number.charAt(i) - '0';
            int next = number.charAt(i + 1) - '0';
            if (current == digitInNumber && current < next) {
                return number.substring(0, i) + number.substring(i + 1);
            }
            else if (current == digitInNumber) {
                lastOccurance = i;
            }
        }
        if (number.charAt(length - 1) == digit) {
            lastOccurance = length - 1;
        }
        return number.substring(0, lastOccurance) + number.substring(lastOccurance + 1);
    }
}