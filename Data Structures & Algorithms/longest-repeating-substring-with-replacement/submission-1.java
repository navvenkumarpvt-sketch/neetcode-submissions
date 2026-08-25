class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left =0, maxLen=0, maxRepeat=0;

        for(int right=0;right<s.length();right++){
            char currChar = s.charAt(right);
            map.put(currChar, map.getOrDefault(currChar, 0)+1);

            maxRepeat = Math.max(maxRepeat, map.get(currChar));
            int nonRepeatingLength = (right-left+1)-maxRepeat;

            if(nonRepeatingLength>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
