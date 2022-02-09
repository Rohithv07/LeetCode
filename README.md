# LeetCode
LeetCode problems that are solved.

take the bit of the ith(from right) digit:
		bit = (mask >> i) & 1;
set the ith digit to 1:
		mask = mask | (1 << i);
set the ith digit to 0:
		mask = mask & (~(1 << i));

![A Sample Structure](https://github.com/Rohithv07/LeetCode/blob/master/diagram.svg)
