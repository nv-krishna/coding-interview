package personal.wuyi.leetcode.p009;

public class MySolution {
	public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x >= 0 && x < 10) {
            return true;
        } else {
            String xStr = String.valueOf(x);
            char[] chars = xStr.toCharArray();
            
            int half = 0;
            if (chars.length % 2 == 0) {
                half = chars.length / 2;
            } else {
                half = (chars.length - 1) / 2;
            }
            
            for (int i = 0; i < half; i++) {
                if (chars[i] != chars[chars.length - 1 - i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
