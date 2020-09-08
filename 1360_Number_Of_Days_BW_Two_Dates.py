from datetime import date
class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        date1List = list(map(int, date1.split('-')))
        date2List = list(map(int, date2.split('-')))
        
        one = date(date1List[0], date1List[1], date1List[2])
        two = date(date2List[0], date2List[1], date2List[2])
        
        numberOfDays = one - two
        return abs(numberOfDays.days)
