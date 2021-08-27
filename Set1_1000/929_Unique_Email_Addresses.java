class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String [] arrayEmail = email.split("@");
            String localPart = arrayEmail[0];
            String domainPart = arrayEmail[1];
            for (int i=0; i<localPart.length(); i++) {
                if (localPart.charAt(i) == '+') {
                    localPart = localPart.substring(0, i);
                    break;
                }
            }
            StringBuffer sb = new StringBuffer();
            sb.append(localPart.replace(".", ""));
            sb.append("@");
            sb.append(domainPart);
            set.add(sb.toString());
        }
        return set.size();
    }
}
