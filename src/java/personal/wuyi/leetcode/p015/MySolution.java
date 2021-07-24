package personal.wuyi.leetcode.p015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySolution {
	public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        } else {
            List<Integer> list = convertIntArrayToIntegerList(nums);
            Collections.sort(list);
            System.out.println(list);
            System.out.println(list.size());
            List<List<Integer>> resultList = new ArrayList<>();
            
            int i = 0;
            int j = list.size() - 1;

            threeSumOnRange(resultList, list, i, j);
            
            if (countOccurrence(list, 0) >= 3 && !resultList.contains(generateList(0, 0, 0))) {
                resultList.add(generateList(0, 0, 0));
            }
            
            return new ArrayList<>(resultList);
        }
    }
    
    public void threeSumOnRange(List<List<Integer>> resultList, List<Integer> list, int i, int j) {
        if (!isNotAllPositiveOrAllNegative(list.get(i), list.get(j))) {
            return;
        }
        if (j <= i + 1) {
            return;
        }
        
        while (absolute(list.get(i)) > 2 * absolute(list.get(j)) && i + 1 < j) {
            i++;
        } 
        while (absolute(list.get(j)) > 2 * absolute(list.get(i)) && i + 1 < j) {
            j--;
        }
        while (i + 2 + 1 < j && list.get(i) == list.get(i+2)) {
            i++;
        }
        while (i + 1 < j - 2 && list.get(j) == list.get(j-2)) {
            j--;
        }
        if (j <= i + 1) {
            return;
        }
        
        int value1 = list.get(i);
        int value2 = list.get(j);
        int target = - (value1 + value2);
        
        if (!resultList.contains(generateList(value1, value2, target))) {
        	
        	System.out.println(value1 + " " + value2);
            if (target <= 0) {      
                for (int m = i + 1; m < j; m++) {
                    if (list.get(m) == target) {
                        resultList.add(generateList(value1, value2, target));
                        break;
                    } else if (list.get(m) > target) {
                        break;
                    } 
                }
            } else if (target > 0) {
                for (int m = j - 1; m > i; m--) {
                    if (list.get(m) == target) {
                        resultList.add(generateList(value1, value2, target));
                        break;
                    } else if (list.get(m) < target) {
                        break;
                    } 
                }
            }
        }
        
        int newI = i+1;
        if (list.get(newI) == list.get(i) && newI < j - 1) {
            newI++;
        }
        threeSumOnRange(resultList, list, newI, j);
        
        int newJ = j-1;
        if (list.get(newJ) == list.get(j) && newJ > i + i) {
            newJ--;
        }
        threeSumOnRange(resultList, list, i, newJ);
    }
    
    
    public boolean isNotAllPositiveOrAllNegative(int i, int j) {
        if (i >= 0 && j <= 0) {
            return true;
        } else if (i <= 0 && j >= 0) {
            return true;
        } else {
            return false;
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
    
    public int absolute(int i) {
        if (i >= 0) {
            return i;
        } else {
            return -i;
        }
    }
    
    public List<Integer> convertIntArrayToIntegerList(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	if (map.get(nums[i]) == null) {
        		list.add(nums[i]);
        		map.put(nums[i], 1);
        	} else if (map.get(nums[i]) < 2) {
        		list.add(nums[i]);
        		map.put(nums[i], map.get(nums[i]) + 1);
        	}
            
        }
        return list;
    }
    
    public int countOccurrence(List<Integer> list, int target) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                count++;
            }
        }
        
        return count;
    }
}
