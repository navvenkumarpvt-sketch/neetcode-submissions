class Solution {
    public boolean isPalindrome(String s) {
        // BRUTE FORCE O(N) with space O(N)
        // String s1 = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        // StringBuilder sb1 = new StringBuilder(s1);
        // if(sb1.reverse().toString().equals(s1)){
        //     return true;
        // }

        // return false;

        // optimal : O(n) time and O(1) space

        int i=0, j=s.length()-1;
        while(i<j){
            char start = s.charAt(i);
            char last = s.charAt(j);

            if(!Character.isLetterOrDigit(start)){
                i++;
            } else if(!Character.isLetterOrDigit(last)){
                j--;
            }else{
                if(Character.toLowerCase(start)!=Character.toLowerCase(last)){
                    return false;
                }
                j--;
                i++;
            }
        }
        return true;
    }
}
