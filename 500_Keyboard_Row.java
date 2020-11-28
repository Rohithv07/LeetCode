class Solution {
    public void fillRow1(Set<Character> row1) {
        row1.add('q');
		row1.add('w');
		row1.add('e');
		row1.add('r');
		row1.add('t');
		row1.add('y');
		row1.add('u');
		row1.add('o');
		row1.add('p');
    }
    public void fillRow2(Set<Character> row2) {
        row2.add('a');
		row2.add('s');
		row2.add('d');
		row2.add('f');
		row2.add('g');
		row2.add('h');
		row2.add('j');
		row2.add('k');
		row2.add('l');
    }
    public void fillRow3(Set<Character> row3) {
        row3.add('z');
		row3.add('x');
		row3.add('c');
		row3.add('v');
		row3.add('b');
		row3.add('n');
		row3.add('m');
    }
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>();
        Set<Character> row2 = new HashSet<>();
        Set<Character> row3 = new HashSet<>();
        fillRow1(row1);
        fillRow2(row2);
        fillRow3(row3);
        boolean inRow1;
        boolean inRow2;
        boolean inRow3;
        List<String> list = new ArrayList<>();
        for (String s: words) {
            String currentWord = s.toLowerCase();
            inRow1 = false;
			inRow2 = false;
			inRow3 = false;
            for (int i=0; i<currentWord.length(); i++) {
                if (i == 0 && row1.contains(currentWord.charAt(i))) {
					inRow1 = true;
				}
				else if (row1.contains(currentWord.charAt(i)) && !inRow1) {
                    inRow1 = false;
                    inRow2 = false;
                    inRow3 = false;
                    break;
                }
				else if (i == 0 && row2.contains(currentWord.charAt(i)))
					inRow2 = true;
				else if (row2.contains(currentWord.charAt(i)) && !inRow2){
                    inRow1 = false;
                    inRow2 = false;
                    inRow3 = false;
                    break;
                }
					
				else if (i == 0 && row3.contains(currentWord.charAt(i)))
					inRow3 = true;
				else if (row3.contains(currentWord.charAt(i)) && !inRow3) {
                    inRow1 = false;
                    inRow2 = false;
                    inRow3 = false;
                    break;
                }
					
			}
			if (inRow1 || inRow2 || inRow3)
				list.add(s);
            }
        return list.toArray(new String[0]);
    }
}
