package personal.wuyi.leetcode.p010;

public class Test {
	public static void main(String[] args) {
		MySolution my = new MySolution();
//		String s1 = "mississippi";
//		String p1 = "mis*is*p*.";
//		System.out.println(my.isMatch(s1, p1));   // false
//		
//		String s2 = "aa";
//		String p2 = "a*";
//		System.out.println(my.isMatch(s2, p2));   // true
//		
//		String s3 = "aaa";
//		String p3 = "ab*a*c*a";
//		System.out.println(my.isMatch(s3, p3));   // true
//		
//		String s4 = "aab";
//		String p4 = "c*a*b";
//		System.out.println(my.isMatch(s4, p4));   // true
//		
//		String s5 = "aaa";
//		String p5 = "a*a";
//		System.out.println(my.isMatch(s5, p5));   // true
//		
//		String s6 = "a";
//		String p6 = "ab*";
//		System.out.println(my.isMatch(s6, p6));   // true
		
		String s7 = "ab";
		String p7 = ".*..";
		System.out.println(my.isMatch(s7, p7));   // true
	}
}
