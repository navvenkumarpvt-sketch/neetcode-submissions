class Solution {
public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() < t.length()) {
        return "";
    }

    int[] targetFreq = new int[128];
    for (char c : t.toCharArray()) {
        targetFreq[c]++;
    }

    int required = 0;
    for (int count : targetFreq) {
        if (count > 0) {
            required++;
        }
    }

    int left = 0, right = 0;
    int formed = 0;
    int[] windowFreq = new int[128];

    int minLen = Integer.MAX_VALUE;
    int minLeft = 0;

    while (right < s.length()) {
        char c = s.charAt(right);
        windowFreq[c]++;

        if (targetFreq[c] > 0 && windowFreq[c] == targetFreq[c]) {
            formed++;
        }

        while (left <= right && formed == required) {
            char leftChar = s.charAt(left);

            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minLeft = left;
            }

            windowFreq[leftChar]--;
            if (targetFreq[leftChar] > 0 && windowFreq[leftChar] < targetFreq[leftChar]) {
                formed--;
            }

            left++;
        }

        right++;
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
}
}
