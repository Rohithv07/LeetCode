class Solution {
    public int convertTime(String current, String correct) {
        if (current.equals(correct)) {
            return 0;
        }
        int currentTime = 0;
        int correctTime = 0;
        String hourStringCurrent = current.substring(0, 2);
        String minuteStringCurrent = current.substring(3, 5);
        int hourCurrent = Integer.valueOf(hourStringCurrent);
        int minuteCurrent = Integer.valueOf(minuteStringCurrent);
        currentTime = hourCurrent * 60 + minuteCurrent;
        String hourStringCorrect = correct.substring(0, 2);
        String minuteStringCorrect = correct.substring(3, 5);
        int hourCorrect = Integer.valueOf(hourStringCorrect);
        int minuteCorrect = Integer.valueOf(minuteStringCorrect);
        correctTime = hourCorrect * 60 + minuteCorrect;
        int minOperation = 0;
        while (correctTime - 60 >= currentTime) {
            correctTime -= 60;
            minOperation++;
        }
        while (correctTime - 15 >= currentTime) {
            correctTime -= 15;
            minOperation++;
        }
        while (correctTime - 5 >= currentTime) {
            correctTime -= 5;
            minOperation++;
        }
        while (correctTime - 1 >= currentTime) {
            correctTime -= 1;
            minOperation++;
        }
        return minOperation;
    }
}