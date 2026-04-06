class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> freq1 = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (freq1.containsKey(c)) {
                freq1.put(c, freq1.get(c) - 1);
            }

            if (freq1.getOrDefault(c, 0) == 0) {
                freq1.remove(c);
            }
        }

        if (freq1.size() == 0) {
            return true;
        }

        return false;

    }
}
