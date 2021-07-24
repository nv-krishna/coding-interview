package personal.wuyi.leetcode.p007;

public class MySolution {
	public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < -Integer.MAX_VALUE) {
            return 0;
        }
        
        if (x == 0) {
            return 0;
        } else {
            boolean isNegative = false;
            int     lastDigit  = 0;
            if (x < 0) {
                isNegative = true;
                lastDigit  = 1;        // ignore negative sign
            }
            
            String xStr         = String.valueOf(x);  
            String yStr         = "";
            char[] chars        = xStr.toCharArray();
            boolean leadingZero = true;
            
            for (int i = chars.length - 1; i >= lastDigit; i--) {
                if (leadingZero && chars[i] == '0') {
                    continue;
                } else {
                    leadingZero = false;
                    yStr = yStr + chars[i];
                }
            }
            
            int result = 0;
            try {
                result = Integer.parseInt(yStr);      // when parse the reversed string, it may cause overflow
            } catch (Exception e) {
                return 0;
            }
                
            if (isNegative) {
                result = -result;
            }
            
            return result;
        }
    }
}
