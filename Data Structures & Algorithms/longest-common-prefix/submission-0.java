class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        Arrays.sort(strs);
        char[] firstWordChars = strs[0].toCharArray();
        char[] lastWordChars = strs[strs.length-1].toCharArray();

        for(int i=0;i<firstWordChars.length;i++){
            if(firstWordChars[i]!=lastWordChars[i]){
                break;
            }
            str.append(firstWordChars[i]);
        }

        return str.toString();
    }
}