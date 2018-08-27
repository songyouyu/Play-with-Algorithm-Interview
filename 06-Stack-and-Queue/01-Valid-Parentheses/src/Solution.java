import java.util.Stack;

/**
 * leetcode 20
 * @author youyusong
 * @date 2018/8/26
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                // 确保栈中还有元素
                if (stack.size() == 0) {
                    return false;
                }

                Character c = stack.pop();
                Character target;
                if (s.charAt(i) == ')') {
                    target = '(';
                } else if (s.charAt(i) == ']'){
                    target = '[';
                } else {
                    target = '{';
                }

                if (! c.equals( target)) {
                    return false;
                }
            }
        }

        // 循环完毕后,若栈中还有元素,则匹配失败
        if (stack.size() != 0) {
            return false;
        }
        return true;
    }
}
