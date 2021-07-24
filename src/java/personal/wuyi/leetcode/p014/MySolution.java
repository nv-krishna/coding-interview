package personal.wuyi.leetcode.p014;

import java.util.List;

public class MySolution {
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        
        String prefix = "";
        
        for (int i = 1; i < 1000; i++) {
            if (i <= strs[0].length()) {
                String currentPrefix = strs[0].substring(0, i);
                
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() < i) {
                        return prefix;
                    } else if (!strs[j].substring(0, i).equals(currentPrefix)) {
                        return prefix;
                    }
                }
                prefix = currentPrefix;
            } else {
                return prefix;
            }
        }
        
        return prefix;
    }
}
