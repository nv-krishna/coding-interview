package personal.wuyi.leetcode.p013;

public class MySolution {
	public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'M') {
                result = result + 1000;
            } else if (chars[i] == 'D') {
                result = result + 500;
            } else if (chars[i] == 'C') {
                result = result + 100;
            } else if (chars[i] == 'L') {
                result = result + 50;
            } else if (chars[i] == 'X') {
                result = result + 10;
            } else if (chars[i] == 'V') {
                result = result + 5;
            } else if (chars[i] == 'I') {
                result = result + 1;
            }
        }
        
        if (s.contains("CD")) {
            result = result - 200;   // 600 => 400
        } 
        if (s.contains("CM")) {
            result = result - 200;   // 1100 => 900
        }
        if (s.contains("XL")) {
            result = result - 20;    // 60 => 40
        }
        if (s.contains("XC")) {
            result = result - 20;    // 110 => 90
        }
        if (s.contains("IV")) {
            result = result - 2;     // 6 => 4
        }
        if (s.contains("IX")) {
            result = result - 2;     // 11 => 9
        }
        
        return result;
    }
}
