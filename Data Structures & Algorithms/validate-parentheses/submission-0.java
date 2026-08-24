class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for( char chr : s.toCharArray()){
            if(chr=='(' || chr=='{' || chr=='['){
                stack.push(chr);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();

                if((top =='(' && chr!=')') 
                || (top =='{' && chr!='}') 
                || (top =='[' && chr!=']')){
                    return false;
                }
            }
        }

        return stack.isEmpty();

        
    }
}
