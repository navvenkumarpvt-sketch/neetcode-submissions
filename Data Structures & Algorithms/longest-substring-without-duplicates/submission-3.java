class Solution {
public int lengthOfLongestSubstring(String s) {
    int maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
        Set<Character> vis = new HashSet<>();

        for (int j = i; j < s.length(); j++) {
            char c = s.charAt(j);

            if (vis.contains(c)) {
                break;
            }

            vis.add(c);
            maxLen = Math.max(maxLen, j - i + 1);
        }
    }

    return maxLen;
}


}
