package personal.wuyi.leetcode.p017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        } else {
            Map<String, String> map = initializeNumberMap();
            List<String> resultList = separateStrIntoList(map.get(digits.substring(0,1)));
            
            for (int i = 1; i < digits.length(); i++) {
                resultList = cross2Lists(resultList, separateStrIntoList(map.get(digits.substring(i, i+1))));
            }
            
            return resultList;
        }
    }
    
    public List<String> cross2Lists(List<String> list1, List<String> list2) {
        List<String> resultList = new ArrayList<>();
        
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                resultList.add(list1.get(i) + list2.get(j));
            }
        }
        
        return resultList;
    }
    
    public List<String> separateStrIntoList(String str) {
        List<String> strList = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {
            strList.add(str.substring(i, i+1));
        }
        
        return strList;
    }
    
    public Map<String, String> initializeNumberMap() {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        return map;
    }
}
