package personal.wuyi.solutionpatterns.quickselect;

public class QuickSelect {
	public int select(int[] nums, int k) {
	    int left  = 0;
	    int right = nums.length - 1;
	    
	    while (left <= right) {
	        int pivotIndex = partition(nums, left, right);
	        if (pivotIndex == k) {
	            return nums[pivotIndex];
	        } else if (pivotIndex > k) {      // It means that k is in the 1st part, so set the right bound
	            right = pivotIndex - 1;
	        } else {                          // It means that k is in the 2nd part, so set the left bound
	            left = pivotIndex + 1;
	        }
	    }
	    
	    return -1;
	}
	
	public int partition(int[] nums, int left, int right) {		
	    int pivot = nums[right];
	    int i = left;
	    for (int j = left; j < right; j++) {
	        if (nums[j] < pivot) {
	        	int temp = nums[i];
	        	nums[i] = nums[j];
	        	nums[j] = temp;
	        	i = i + 1;
	        }
	    }
	    int temp2 = nums[i];
    	nums[i] = nums[right];
    	nums[right] = temp2;
	    return i;
	}
}
