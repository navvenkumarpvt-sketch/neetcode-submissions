class Solution {
public boolean checkInclusion(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    
    if (n1 > n2) return false;

    int[] s1Count = new int[26];
    int[] s2Count = new int[26];

    // 1. Initialize frequency arrays for s1 and the first window of s2
    for (int i = 0; i < n1; i++) {
        s1Count[s1.charAt(i) - 'a']++;
        s2Count[s2.charAt(i) - 'a']++;
    }

    // Check if the very first window matches
    if (matches(s1Count, s2Count)) return true;

    // 2. Slide the window across s2
    for (int i = n1; i < n2; i++) {
        // Add the new character entering the window on the right
        s2Count[s2.charAt(i) - 'a']++;
        
        // Remove the old character leaving the window on the left
        s2Count[s2.charAt(i - n1) - 'a']--;

        // Check if the current window matches
        if (matches(s1Count, s2Count)) return true;
    }

    return false;
}

// Helper method to compare two 26-element arrays
private boolean matches(int[] a1, int[] a2) {
    for (int i = 0; i < 26; i++) {
        if (a1[i] != a2[i]) return false;
    }
    return true;
}
}
