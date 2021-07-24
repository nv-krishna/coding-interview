package personal.wuyi.leetcode.p018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySolution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        } else {
            List<Integer> list = convertIntArrayToIntegerList(nums);
            Collections.sort(list);
            int size = list.size();
            
            if (list.get(0) + list.get(1) + list.get(2) + list.get(3) > target) {
                return new ArrayList<>();
            }
            if (list.get(size-1) + list.get(size-2) + list.get(size-3) + list.get(size-4) < target) {
                return new ArrayList<>();
            }
            
            List<List<Integer>> resultList = new ArrayList<>();
            
            for (int a = 0; a < size - 3; a++) {
                for (int b = a + 1; b < size - 2; b++) {
                    for (int c = b + 1; c < size - 1; c++) {
                        for (int d = c + 1; d < size; d++) {
                            int sum = list.get(a) + list.get(b) + list.get(c) + list.get(d);
                            
                            if (sum == target && !resultList.contains(generateList(list.get(a), list.get(b), list.get(c), list.get(d)))) {
                                resultList.add(generateList(list.get(a), list.get(b), list.get(c), list.get(d)));
                            }
                        }
                    }
                }
            }
            
            return resultList;
        }
    }
    
    public List<Integer> generateList(int a, int b, int c, int d) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        Collections.sort(list);
        return list;
    }
    
    public List<Integer> convertIntArrayToIntegerList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	list.add(nums[i]);
        }
        return list;
    }
}
