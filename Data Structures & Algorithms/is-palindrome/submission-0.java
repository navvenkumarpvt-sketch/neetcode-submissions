class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb1 = new StringBuilder(s1);
        if(sb1.reverse().toString().equals(s1)){
            return true;
        }

        return false;
    }
}
