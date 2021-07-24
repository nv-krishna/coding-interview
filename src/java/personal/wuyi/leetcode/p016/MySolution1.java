package personal.wuyi.leetcode.p016;

public class MySolution1 {
	public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minimalGap = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int currentGap = absolute(target-(nums[i] + nums[j] + nums[k]));
                    if (currentGap < minimalGap) {
                        minimalGap = currentGap;
                        closestSum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        
        return closestSum;
    }
    
    public int absolute(int i) {
        if (i >= 0) {
            return i;
        } else {
            return -i;
        }
    }
}
