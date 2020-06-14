/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
   var num1 = 0, num2 = 1, temp;
    for(i=0; i<n; i++){
        temp = num1;
        num1 = num2;
        num2 = num1 + temp
    }
    return num2
};
