package personal.wuyi.solutionpatterns.quickselect;

public class QuickSelectTest {
	public static void main(String[] args) {
		QuickSelect qs = new QuickSelect();
		
		int[] nums = new int[] {3,4,7,1,9,3,6};
		int result = qs.select(nums,nums.length - 1);
		System.out.println(result);
	}
}
