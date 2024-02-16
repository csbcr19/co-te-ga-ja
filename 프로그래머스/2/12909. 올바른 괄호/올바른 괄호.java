import java.util.Stack;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        try{
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    stack.pop();
                }
            }
        return stack.empty();
        } catch(Exception e) { 
            return false;
        }
    }
}