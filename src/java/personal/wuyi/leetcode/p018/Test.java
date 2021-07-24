package personal.wuyi.leetcode.p018;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] nums = new int[] {1,0,-1,0,-2,2};
		MySolution my = new MySolution();
		List<List<Integer>> resultList = my.fourSum(nums, 0);
		for (List<Integer> result: resultList) {
			System.out.println(result);
		}
	}
}
