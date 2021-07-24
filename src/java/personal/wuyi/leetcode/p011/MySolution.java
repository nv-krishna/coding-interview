package personal.wuyi.leetcode.p011;

public class MySolution {
	public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        
        int current = 0;
        int best    = 0;
        
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                current = calculateCapacity(height, i, j);
                if (current > best) {
                    best = current;
                }
            }
        }
        
        return best;
    }
    
    public int calculateCapacity(int[] height, int i, int j) {
        if (height[i] > height[j]) {
            return (j - i) * height[j];
        } else if (height[i] < height[j]) {
            return (j - i) * height[i];
        } else {
            return (j - i) * height[i];
        }
    }
}
