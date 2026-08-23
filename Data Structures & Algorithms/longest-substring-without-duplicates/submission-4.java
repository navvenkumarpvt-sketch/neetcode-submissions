class Solution {
public int lengthOfLongestSubstring(String s) {

    //brute force tune 0(n^2) :  
    // int maxLen = 0;

    // for (int i = 0; i < s.length(); i++) {
    //     Set<Character> vis = new HashSet<>();

    //     for (int j = i; j < s.length(); j++) {
    //         char c = s.charAt(j);

    //         if (vis.contains(c)) {
    //             break;
    //         }

    //         vis.add(c);
    //         maxLen = Math.max(maxLen, j - i + 1);
    //     }
    // }

    // return maxLen;


    // OPTIMAL HashMap sliding-window solution is O(n) time and O(k) space, where k is the number of distinct characters.

    int maxLen =0, left =0;
    Map<Character, Integer> map = new HashMap<>();
    for(int right =0;right<s.length();right++){
        char currChar = s.charAt(right);

        if(map.containsKey(currChar)){
            left = Math.max(left, map.get(currChar)+1);
        }

        map.put(currChar, right);
        maxLen = Math.max(maxLen, right-left+1);
    }

    return maxLen;
}


}
