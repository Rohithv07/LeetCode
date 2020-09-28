/*
My thought process
So here we need to convert the given date format inot yy-mm-dd format into digits ie, the months given as jaan, feb etc must be converted into 01, 02, 03 etc.
So we can make use of a map to store the 12 months along with the respective number for that month.
So after doing that we can split our given string based on space.
So we will get [day, month, year]
Now there is a tricky part with the day that it may be given as 12st, 23rd, 22nd etc. SO we only need the numeric part + if the day is only a single digit, then we need a 0 at the very beginning of the digit.

In case of 2nd, 3rd like string, the length will be only 3, So we can check wheter length is 3, if yes add 0 + substr(only numeric)
Else
we take substr(only numeric part);

Then just take the value of month from map, then the year and use a string builder to make the whole string together and return as a string and thats the problem.

*/

class Solution {
    public String reformatDate(String date) {
        Map<String, String> month = new HashMap<>();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");
        String [] arr = date.split(" ");
        String currentDay = arr[0];
        String currentMonth = arr[1];
        String currentYear = arr[2];
        String updateDay = "";
        String updatedMonth = month.get(currentMonth);
        if (currentDay.length() == 3) {
            updateDay += "0" + currentDay.substring(0, 1);
        }
        else
            updateDay += currentDay.substring(0, 2);
        StringBuilder sb = new StringBuilder();
        sb.append(currentYear);
        sb.append("-");
        sb.append(updatedMonth);
        sb.append("-");
        if (updateDay.length() < 2) {
        sb.append("0");
        sb.append(updateDay);
        }
        else
            sb.append(updateDay);
        return sb.toString();
            
    }
}
