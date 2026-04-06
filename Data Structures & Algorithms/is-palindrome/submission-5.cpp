class Solution {
public:
    bool isPalindrome(string s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !isAlphaNum(s[l])) {
                l++;
            }

            while (r > l && !isAlphaNum(s[r])) {
                r--;
            }

            if ((char)tolower(s[l]) != (char)tolower(s[r])) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    bool isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
};
