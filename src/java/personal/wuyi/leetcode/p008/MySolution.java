package personal.wuyi.leetcode.p008;

public class MySolution {
	public int myAtoi(String str) {
        if (str == null) {
            return 0;
        } else if (str.isEmpty()) {
            return 0;
        } else {
            char[] chars = str.toCharArray();
            
            String result = "";
            
            boolean isAlreadyHitNonSpace = false;     // track the current point already hit non white space character or not
            boolean isAlreadyHitNumber   = false;     // track the current point already hit number or no
            boolean isNegative           = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    if (!isAlreadyHitNonSpace && !isAlreadyHitNumber) {
                        continue;
                    } else {                                           // if already hit number and the current is a white space, stop
                        break;
                    }
                } else {
                    if (!Character.isDigit(chars[i])) {
                        if (isAlreadyHitNumber) {
                            break;
                        }
                        if ((chars[i] == '-' || chars[i] == '+') && !isAlreadyHitNonSpace) {
                            isAlreadyHitNonSpace = true;
                            if (chars[i] == '-') {
                                result = result + chars[i];
                                isNegative = true;
                            }
                        } else {
                            break;
                        }
                    } else {
                        isAlreadyHitNonSpace = true;
                        isAlreadyHitNumber   = true;
                        result = result + chars[i];
                    }
                }
            }
            
            if (result.isEmpty() || !isAlreadyHitNumber) {    // if the string just "-" or "+", return 0
                return 0;
            } else {
                int resultInt = 0;
                
                try {
                    resultInt = Integer.parseInt(result);     // if overflow, return the MAX_VALUE or MIN_VALUE of integer
                } catch (Exception e) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                
                return resultInt;
            }
        }
    }
}
