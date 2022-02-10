class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank == null || bank.length == 0) {
            return 0;
        }
        int laserCount = 0;
        List<Integer> deviceInEachRow = new ArrayList<>();
        for (String device : bank) {
            int count = 0;
            for (char d : device.toCharArray()) {
                if (d == '1') {
                    count += 1;
                }
            }
            if (count != 0) {
                deviceInEachRow.add(count);
            }
        }
        if (deviceInEachRow.size() == 1) {
            return 0;
        }
        for (int i = 0; i < deviceInEachRow.size() - 1; i++) {
            laserCount += (deviceInEachRow.get(i) * deviceInEachRow.get(i + 1));
        }
        return laserCount;
    }
}