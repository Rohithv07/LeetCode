class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        if numBottles < numExchange:
            return numBottles
        totalBottle = numBottles
        remainingBottles = numBottles
        while remainingBottles >= numExchange:
            toExchange = remainingBottles // numExchange
            totalBottle += toExchange
            remainingBottles = remainingBottles - toExchange * numExchange + toExchange
        return totalBottle
