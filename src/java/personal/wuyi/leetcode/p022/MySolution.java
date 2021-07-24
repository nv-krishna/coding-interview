package personal.wuyi.leetcode.p022;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
	public List<String> generateParenthesis(int n) {
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        } else {
            List<String> previouList1 = generateParenthesis(n - 1);
            List<String> currentList = new ArrayList<>();
            
            for (String result : previouList1) {
                currentList.add("(" + result + ")");
            }
            
            for (int i = 1; i < n; i++) {
                List<String> previouListA = generateParenthesis(i);
                List<String> previouListB = generateParenthesis(n-i);
                
                for (String resultA : previouListA) {
                    for (String resultB : previouListB) {
                        if (!currentList.contains(resultA+resultB)) {
                            currentList.add(resultA+resultB);
                        }
                        if (!currentList.contains(resultB+resultA)) {
                            currentList.add(resultB+resultA);
                        }
                    }
                }
            }
            
            return currentList;
        }
    }
}
