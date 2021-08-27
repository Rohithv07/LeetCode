class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        Arrays.sort(folder);
        for (String current : folder) {
            if (result.isEmpty() || !current.startsWith(result.get(result.size() - 1) + "/"))
                result.add(current);
        }
        return result;
    }
}


/*
	// In ASCII, '/' is before 'a': e.g., '/a', '/a/b', '/aa'
	// After sorting the folder array, we only need to consider if the current folder is a subfolder of the previous one or not.
*/
