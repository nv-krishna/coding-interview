package personal.wuyi.leetcode.p015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution2 {
	public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        } else {
        	List<List<Integer>>   resultList   = new ArrayList<>();
            Map<Integer, Integer> positiveMap  = new HashMap<>();
            Map<Integer, Integer> negativeMap  = new HashMap<>();
            int                   zeroCount    = 0;
            
            for (int i : nums) {
            	if (i > 0) {
            		if (positiveMap.get(i) == null) {
            			positiveMap.put(i, 1);
            		} else {
            			positiveMap.put(i, positiveMap.get(i) + 1);
            		}
            	} else if (i < 0) {
            		if (negativeMap.get(i) == null) {
            			negativeMap.put(i, 1);
            		} else {
            			negativeMap.put(i, negativeMap.get(i) + 1);
            		}
            	} else {
            		zeroCount++;
            	}
            }
            
            if (zeroCount >= 3) {
                resultList.add(generateList(0, 0, 0));
            }
            if (positiveMap.isEmpty() || negativeMap.isEmpty()) {
            	return resultList;
            }
            
            List<Integer> positiveUniqueList = new ArrayList<>(positiveMap.keySet());
            List<Integer> negativeUniqueList = new ArrayList<>(negativeMap.keySet());
            Collections.sort(positiveUniqueList);
            Collections.sort(negativeUniqueList);
            
            int i = 0;
            
            while (i < negativeUniqueList.size()) {
            	int j = positiveUniqueList.size() - 1;
            	while (j >= 0) {
            		int value1 = negativeUniqueList.get(i);
            		int value2 = positiveUniqueList.get(j);
            		
            		if (absolute(value1) == absolute(value2)) {                                                                  // case 1: (x, -x)
            			if (zeroCount > 0 && !resultList.contains(generateList(value1, 0, value2))) {
            				resultList.add(generateList(value1, 0, value2));
            			}
            		} else if (absolute(value1) > absolute(value2)) {                                                            // case 2
            			if (absolute(value1) > absolute(value2) * 2) {
            				break;
            			} else if (absolute(value1) == absolute(value2) * 2) {
            				if (positiveMap.get(value2) > 1 && !resultList.contains(generateList(value1, value2, value2))) {
            					resultList.add(generateList(value1, value2, value2));
            				}
            			} else {
            				int target = 0 - (value1 + value2);    // target is positive
            				if (positiveMap.get(target) != null && !resultList.contains(generateList(value1, target, value2))) {
            					resultList.add(generateList(value1, target, value2));
            				}
            			}
            		} else if (absolute(value1) < absolute(value2)) {                                                            // case 3
            			if (absolute(value2) > absolute(value1) * 2) {
                			// 
                		} else if (absolute(value2) == absolute(value1) * 2) {
                			if (negativeMap.get(value1) > 1 && !resultList.contains(generateList(value1, value1, value2))) {
                				resultList.add(generateList(value1, value1, value2));
                			}
                		} else {
                			int target = 0 - (value1 + value2);    // target is negative
                			if (negativeMap.get(target) != null && !resultList.contains(generateList(value1, target, value2))) {
            					resultList.add(generateList(value1, target, value2));
            				}
                		}
            		}
            		j--;
            	}
            	i++;
            }
            
            return resultList;
        }
    }
	
	public int absolute(int i) {
        if (i >= 0) {
            return i;
        } else {
            return -i;
        }
    }
	
	public List<Integer> generateList(int x, int y, int z) {
        List<Integer> list = new ArrayList<>();
        list.add(x);
        list.add(y);
        list.add(z);
        Collections.sort(list);
        return list;
    }
}
