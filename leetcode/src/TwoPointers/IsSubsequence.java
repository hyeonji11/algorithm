package TwoPointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        if(s.length() == 0) return true;

        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == s.charAt(si)) {
                si++;
                if(si == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
