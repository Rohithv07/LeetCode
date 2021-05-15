class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
	int length = s.length();
	if (length == 1 && !Character.isDigit(s.charAt(0)))
		return false;
		boolean numberSeen = false;
		boolean eSeen = false;
		boolean pointSeen = false;
		for (int i=0; i<length; i++) {
			char ch = s.charAt(i);
			if ('0' <= ch && ch <= '9') 
				numberSeen = true;
			else if (ch == '.') {
				if (eSeen || pointSeen)
					return false;
				pointSeen = true;
			}
			else if (ch == 'e' || ch == 'E') {
				if (eSeen || !numberSeen)
					return false;
				numberSeen = false;
				eSeen = true;
			}
			else if (ch == '-' || ch == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
					return false;
				}
			}
			else 
				return false;
		}
		return numberSeen;
 }
}

