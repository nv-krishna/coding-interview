package personal.wuyi.leetcode.p012;

public class MySolution {
	public String intToRoman(int num) {
        String result = "";
        
        // M
        int mDiv = num / 1000;
        if (mDiv > 0) {
            result = result + duplicate("M", mDiv);
        }
        num = num % 1000;
        
        // C & D
        result = result + calculateOneCombo(num, 100, "M", "D", "C");
        num = num % 100;
        
        // L & X
        result = result + calculateOneCombo(num, 10, "C", "L", "X");
        num = num % 10;
        
        // V & I
        result = result + calculateOneCombo(num, 1, "X", "V", "I");
        
        return result;
    }
    
    public String calculateOneCombo(int num, int level, String tenStr, String fiveStr, String oneStr) {
        String result = "";
        int    div  = num / level;
        
        if (div == 0) {
            return "";
        } else if (div == 9) {
            result = result + oneStr + tenStr;
        } else if (div == 4) {
            result = result + oneStr + fiveStr;
        } else if (div >= 5) {
            result = result + fiveStr;
            result = result + duplicate(oneStr, div - 5);
        } else {
            result = result + duplicate(oneStr, div);
        }
        
        return result;
    }
    
    public String duplicate(String str, int times) {
        String result = "";
        
        for (int i = 1; i <= times; i++) {
            result = result + str;
        }
        
        return result;
    }
}
