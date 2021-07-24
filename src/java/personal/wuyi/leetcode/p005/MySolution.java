package personal.wuyi.leetcode.p005;

public class MySolution {
	public String longestPalindrome(String s) {
		if (s == null) {
			return "";
		} else if (s.isEmpty()) {
			return "";
		} else if (s.length() == 1) {
			return s;
		} else if (s.length() == 2) {
			char[] chars = s.toCharArray();

			if (chars[0] == chars[1]) {
				return s;
			} else {
				return chars[0] + "";
			}
		} else {
			char[] chars = s.toCharArray();

			// handle center is one element (xxcxx)
			int c = 1;       // the center pointer
			int w = 1;       // the width of window

			String result = chars[0] + "";
			int currentLength = 1;
			int maxLength = 1;

			while (c <= chars.length - 2) {
				while (c - w >= 0 && c + w <= chars.length - 1) {
					if (chars[c - w] == chars[c + w]) {
						currentLength = 1 + 2 * w;
						if (currentLength > maxLength) {
							maxLength = currentLength;
							result = extractSubString(chars, c - w, c + w);
						}
						w++;
					} else {
						break;
					}
				}
				c++;
				w = 1;
			}

			// handle center between 2 same elements (xxccxx)
			c = 0;
			w = 0;

			while (c <= chars.length - 2) {
				if (chars[c] == chars[c + 1]) {
					while (c - w >= 0 && c + 1 + w <= chars.length - 1) {
						if (chars[c - w] == chars[c + 1 + w]) {
							currentLength = 2 + 2 * w;
							if (currentLength > maxLength) {
								maxLength = currentLength;
								result = extractSubString(chars, c - w, c + 1 + w);
							}
							w++;
						} else {
							break;
						}
					}
				}
				c++;
				w = 0;
			}

			return result;
		}
	}

	public String extractSubString(char[] chars, int i, int j) {
		String result = "";
		for (int x = i; x <= j; x++) {
			result = result + chars[x];
		}
		return result;
	}
}

