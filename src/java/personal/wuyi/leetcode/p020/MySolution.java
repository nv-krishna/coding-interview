package personal.wuyi.leetcode.p020;

import java.util.Stack;

public class MySolution {
	public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        } else if (s.length() == 1) {
            return false;
        } else {
            Stack<String> stack = new Stack<String>();
            
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(i, i+1);
                
                if (str.equals("(") || str.equals("{") || str.equals("[")) {
                    stack.push(str);
                } else if (str.equals(")") || str.equals("}") || str.equals("]")) {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        String pop = stack.pop();
                        
                        if (str.equals(")") && pop.equals("(")) {
                            continue;
                        } else if (str.equals("}") && pop.equals("{")) {
                            continue;
                        } else if (str.equals("]") && pop.equals("[")) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
            
            return stack.isEmpty();
        }
    }
}
