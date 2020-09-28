/* here we need to find the depth of the folder and return that, that much number of steps will be required to move back.
So we can easily go through the logs array and check wheter the particular string == "../" or "./" or "x/"

if "../"   -> Then find the max(0, noOfSteps-1) as we have to move one step backward
if "./"    -> We dont want to do anytghing, just continue
if "x/"    -> We have a child node, so our step increase to reach the parent node.

This is the whole problem.

*/
class Solution {
    public int minOperations(String[] logs) {
        int noOfSteps = 0;
        for (String s: logs) {
            if (s.equals("../"))
                noOfSteps = Math.max(noOfSteps-1, 0);
            else if (s.equals("./"))
                continue;
            else
                noOfSteps += 1;
        }
        return noOfSteps;
    }
}
