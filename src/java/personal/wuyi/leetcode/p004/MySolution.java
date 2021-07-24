package personal.wuyi.leetcode.p004;

public class MySolution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {                                     // if nums1 is empty, use the median of nums2 as final result
            return findMedianSortedArray(nums2);
        } else if (nums2.length == 0) {                              // if nums2 is empty, use the median of nums1 as final result
            return findMedianSortedArray(nums1); 
        } else if (nums1.length == 1 && nums2.length == 1) {         // if one number in nums1 and one number in nums2, calculate it anyway
            return (nums1[0] + nums2[0]) / 2.0;
        } else {
        	/** Declare variables **/
            int i1 = 0;
            int i2 = 0;
            int j1 = nums1.length - 1;
            int j2 = nums2.length - 1;
            int lowEndIn  = getLowEnd(nums1, nums2, i1, i2, -1);     // indicate current low end of the window in which array
                                                                     // 1 means low end in nums1, 2 means low  end in nums2 
            int highEndIn = getHighEnd(nums1, nums2, j1, j2, -1);    // indicate current high end of the window in which array
                                                                     // 1 means end end in nums1, 2 means high end in nums2 
            int step = 0;                                            // how many step spend
            int lowTerminate  = -1;                                  // -1 means we use both nums1 and nums2, 1 means nums1 has been run entirely, 2 means nums2 has been has been run entirely
            int highTerminate = -1;                                  // -1 means we use both nums1 and nums2, 1 means nums1 has been run entirely, 2 means nums2 has been has been run entirely
            
            while(true) {
            	/** Count steps **/
                step++;
                
                /** Move low end to next position **/
                if (lowEndIn == 1) {                                 // if low end in nums1
                    if (i1 == nums1.length - 1) {                        // if low end already run through the entire nums1, jump low end to nums2 and terminate nums1 for low end
                        lowEndIn = 2;
                        lowTerminate = 1;
                    } else {                                             // if not, move low end to next right position on nums1, judge the new low end
                        i1++;
                        lowEndIn = getLowEnd(nums1, nums2, i1, i2, lowTerminate);
                    }
                } else if (lowEndIn == 2) {                          // if low end in nums2
                    if (i2 == nums2.length - 1) {                        // if low end already run through the entire nums2, jump low end to nums1 and terminate nums2 for low end
                        lowEndIn = 1;
                        lowTerminate = 2;
                    } else {                                             // if not, move low end to next right position on nums2, judge the new low end
                        i2++;
                        lowEndIn = getLowEnd(nums1, nums2, i1, i2, lowTerminate);
                    }
                }
                
                /** Move low end to next position **/
                if (highEndIn == 1) {                                // if high end in nums1
                    if (j1 == 0) {                                       // if high end already run through the entire nums1, jump high end to nums2 and terminate nums1 for high end
                        highEndIn = 2;
                        highTerminate = 1;
                    } else {                                             // if not, move high end to next left position on nums1, judge the new high end
                        j1--;
                        highEndIn = getHighEnd(nums1, nums2, j1, j2, highTerminate);
                    }
                } else if (highEndIn == 2) {                         // if high end in nums2
                    if (j2 == 0) {                                       // if high end already run through the entire nums2, jump high end to nums1 and terminate nums2 for high end
                        highEndIn = 1;
                        highTerminate = 2;
                    } else {                                             // if not, move high end to next left position on nums2, judge the new high end
                        j2--;
                        highEndIn = getHighEnd(nums1, nums2, j1, j2, highTerminate);
                    }
                }
                
                /** Terminate the loop and return median (if low end and high end reach the same position) **/
                if (highEndIn == lowEndIn && highEndIn == 1 && i1 == j1) {               // reach in nums1, return that number in nums1 directly
                    return nums1[i1];   
                }
                
                if (highEndIn == lowEndIn && highEndIn == 2 && i2 == j2) {               // reach in nums2, return that number in nums2 directly
                    return nums2[i2];
                }
                
                /** Terminate the loop and return median (use number of steps to terminate the loop) **/
                if ((nums1.length + nums2.length) % 2 == 0) {                            // if total number is even, the median number is calculated by 2 middle numbers
                    if (step == ((nums1.length + nums2.length) / 2) - 1) {               //     how many steps need to go to reach 2 middle numbers: (totalCount / 2) - 1
                    	                                                                 //     when reach that steps, locate and get average of low end and high end
                        if (lowEndIn == 1) {
                            if (highEndIn == 1) {
                                return (nums1[i1] + nums1[j1]) / 2.0;
                            } else {
                                return (nums1[i1] + nums2[j2]) / 2.0;
                            }
                        } else if (lowEndIn == 2) {
                            if (highEndIn == 1) {
                                return (nums2[i2] + nums1[j1]) / 2.0;
                            } else {
                                return (nums2[i2] + nums2[j2]) / 2.0;
                            }
                        }
                    }
                } else {
                    if (step == ((nums1.length + nums2.length + 1) / 2) - 1) {           // if total number is odd, the median number is the only one number in middle
                    	                                                                 //     how many steps need to go to reach 2 middle numbers: ((totalCount + 1) / 2) - 1
                    	                                                                 //     when reach that steps, locate and return either low end or high end (they should point to the same number)
                        if (lowEndIn == 1) {
                            return nums1[i1];
                        } else if (lowEndIn == 2) {
                            return nums2[i2];
                        }
                        
                    }
                }
            }
        }
    }
    
    /**
     * Find the low end in which array, nums1 or nums2
     */
    public int getLowEnd(int[] nums1, int[] nums2, int i1, int i2, int lowTerminate) {
    	if (lowTerminate == 1) {                 // if low end already run through the entire nums1, return 2 anyway
    		return 2;
    	} else if (lowTerminate == 2) {          // if low end already run through the entire nums2, return 1 anyway
    		return 1;
    	}
    	
        if (nums1[i1] < nums2[i2]) {             // find which number is smaller
            return 1;
        } else {
            return 2;
        }
    }
    
    /**
     * Find the high end in which array, nums1 or nums2
     */
    public int getHighEnd(int[] nums1, int[] nums2, int j1, int j2, int highTerminate) {
    	if (highTerminate == 1) {                // if high end already run through the entire nums1, return 2 anyway
    		return 2;
    	} else if (highTerminate == 2) {         // if high end already run through the entire nums2, return 1 anyway
    		return 1;
    	}
    	
        if (nums1[j1] > nums2[j2]) {             // find which number is larger
            return 1;
        } else {
            return 2;
        }
    }
    
    /**
     * Find the median from a single sorted array
     */
    public double findMedianSortedArray(int[] nums) {
        if (nums.length == 0) {
            return 0.0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length % 2 == 1) {
            return nums[(nums.length - 1) / 2];
        } else {
            return (nums[nums.length / 2] + nums[(nums.length / 2) - 1]) / 2.0;
        }
    }
}
