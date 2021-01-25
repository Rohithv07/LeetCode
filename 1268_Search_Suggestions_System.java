// taking the prefix -> searching the prefix -> Adding the matched strings to list

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        for (int i=1; i<=searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            int key = Arrays.binarySearch(products, prefix);
            while (key > 0 && prefix.equals(products[key - 1]))
                key --;
            if (key < 0)
                key = ~key;
            List<String> typed = new ArrayList<>();
            for (int j=key+3; key < products.length && key < j && products[key].startsWith(prefix); key++)
                typed.add(products[key]);
            result.add(typed);
        }
        return result;
    }
}
