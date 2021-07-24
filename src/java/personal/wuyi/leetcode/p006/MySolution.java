package personal.wuyi.leetcode.p006;

public class MySolution {
	public String convert(String s, int numRows) {
        if (s.length() <=  numRows || numRows == 1) {      // if numRows == 1,             it will be one horizontal line
            return s;                                      // if string.length <= numRows, it will be one vertical line
        }
        
        String result = "";
        char[] chars = s.toCharArray();
        int gap = (numRows - 2) * 2 + 2;                   // the general gap for first line and last line
        
        for (int l = 0; l < numRows; l++) {
            // first or last line
            if (l == 0 || l == numRows - 1) {
                for (int i = l; i < chars.length ; i = i + gap) {
                    result = result + chars[i];
                }
            } else {
                int gap1 = gap - l * 2;                    // in middle line, there are 2 gaps
                int gap2 = l * 2;
                int useWhichGap = 1;                       // 2 gaps will be added alternately, this is the indicator about which is the next gap needs to be added
                
                int i = l;
                while (i < chars.length) {
                    result = result + chars[i];
                    if (useWhichGap == 1) {
                        i = i + gap1;
                        useWhichGap = 2;
                    } else {
                        i = i + gap2;
                        useWhichGap = 1;
                    }
                }
            }
        }
        
        return result;
    }
}
