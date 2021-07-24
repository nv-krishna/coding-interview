package personal.wuyi.leetcode.p003;

public class MySolution {
	public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int start         = 0;
        int end           = 0;
        int maxLength     = 1;
        int currentLength = 0;
        
        while (end < chars.length) {
            if (start == end) {
                currentLength = 1;
                end++;
            } else {
                if (hasChar(chars, start, end-1, chars[end])) {
                    start = start + 1;
                    end = start;
                    currentLength = 0;
                } else {
                    currentLength++;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    end++;
                }
            }
        }
        
        return maxLength;
    }
    
    public boolean hasChar(char[] chars, int start, int end, char target) {
        for (int i = start; i <= end; i++) {
            if (chars[i] == target) {
                return true;
            }
        }
        return false;
    }
}
