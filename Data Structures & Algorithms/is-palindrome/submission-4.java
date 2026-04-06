class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length()-1;

        while (p1 < p2) {
            while (p1 < p2 && !isValid(s.charAt(p1))) {
                p1++;
            }
            while (p1 < p2 && !isValid(s.charAt(p2))) {
                p2--;
            }

            if (Character.toLowerCase(s.charAt(p1)) != 
                Character.toLowerCase(s.charAt(p2))) return false;
            p1++;
            p2--;
        }

        return true;
    }

    public boolean isValid(char c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }
}
