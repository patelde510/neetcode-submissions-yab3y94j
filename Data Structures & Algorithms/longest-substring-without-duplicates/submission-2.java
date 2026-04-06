class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slider = s.length();
        Set<String> seen = new HashSet<>();
        while (slider > 0) {
            int start = 0;
            for (int i = 0; i <= s.length() - slider; i++) {
                if (!seen.contains(s.substring(start, start+slider))) {
                    if (isUnique(s.substring(start, start+slider))) {
                        return slider;
                    }
                }
                start++;
            }
            slider--;
        }
        return 0;
    }

    public boolean isUnique(String s) {
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!seen.add(c)) {
                return false;
            }
        }

        return true;
    }
}
