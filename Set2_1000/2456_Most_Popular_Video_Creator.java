class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Triplet> track = new HashMap<>();
        int length = creators.length;
        for (int i = 0; i < length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            if (track.containsKey(creator)) {
                Triplet currentTriplet = track.get(creator);
                if (currentTriplet.count == view) {
                    String currentString = currentTriplet.s;
                    if (currentString.compareTo(id) > 0) {
                        currentTriplet.s = id;
                    }
                }
                else if (currentTriplet.count < view) {
                    currentTriplet.count = view;
                    currentTriplet.s = id;
                }
                currentTriplet.sum += view;
                track.put(creator, currentTriplet);
            }
            else {
                Triplet currentTriplet = new Triplet(id, view, view);
                track.put(creator, currentTriplet);
            }
        }
        int maxViewRecorded = -1;
        for (String key : track.keySet()) {
            Triplet currentTriplet = track.get(key);
            String id = currentTriplet.s;
            int view = currentTriplet.sum;
            if (view >= maxViewRecorded) {
                maxViewRecorded = view;
            }
        }
        for (String key : track.keySet()) {
            Triplet currentTriplet = track.get(key);
            String id = currentTriplet.s;
            int view = currentTriplet.sum;
            if (view == maxViewRecorded) {
                List<String> currentRecord = new ArrayList<>();
                currentRecord.add(key);
                currentRecord.add(id);
                result.add(new ArrayList<>(currentRecord));
            }
        }
        return result;
    }
}

class Triplet {
    String s;
    int sum;
    int count;
    
    public Triplet(String s, int sum, int count) {
        this.s = s;
        this.sum = sum;
        this.count = count;
    }
}