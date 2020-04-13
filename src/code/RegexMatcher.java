package code;

public class RegexMatcher {

    String s;
    String p;

    public static void main(String[] args) {
        RegexMatcher r = new RegexMatcher();
        System.out.println(r.isMatch("b", "a*b*a*"));
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return isMatchHelper(0, 0, '_');
    }

    private boolean isMatchHelper(int sPos, int pPos, char prev) {
        if (sPos == this.s.length() && pPos == this.p.length()) {
            return true;
        }
        if (pPos == this.p.length())
            return false;
        char pChar = this.p.charAt(pPos);
        char nsChar = '?';
        int nextPPos = pPos + 1;
        if (nextPPos < this.p.length()) {
            nsChar = this.p.charAt(nextPPos);
        }
        if (nsChar == '*') {
            if (isMatchHelper(sPos, pPos + 2, prev)) {
                return true;
            }
        }
        if (sPos == this.s.length()) {
            if (pChar == '*') {
                if (isMatchHelper(sPos, pPos + 1, prev)) {
                    return true;
                }
            }
            return false;
        }
        char sChar = this.s.charAt(sPos);
        if (pChar == '*') {
            if (sChar == prev || prev == '.') {
                if (isMatchHelper(sPos + 1, pPos, prev)) {
                    return true;
                }
                // if(isMatchHelper(sPos + 1, pPos + 1, prev)) {
                // return true;
                // }
            }
            if (isMatchHelper(sPos, pPos + 1, prev)) {
                return true;
            }
        }
        if (sChar == pChar || pChar == '.') {
            if (isMatchHelper(sPos + 1, pPos + 1, pChar)) {
                return true;
            }
        }

        return false;
    }

}
