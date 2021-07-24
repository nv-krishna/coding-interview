package personal.wuyi.leetcode.p010;

public class MySolution {
	public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {                      // p is empty
            return true;
        } else if (p.length() == 1) {           // p has one character
            char[] pChars = p.toCharArray();
            
            if (pChars[0] == '.') {
                return (s.length() == 1);
            } else if (pChars[0] == '*') {
                return true;
            } else {
                return s.equals(p);
            }
        } else {
            char[] pChars = p.toCharArray();
            char[] sChars = s.toCharArray();
            
            int pi = 0;
            int si = 0;
            
            while (pi < pChars.length && si < sChars.length) {         // use 2 pointers to scan p
                if (pi + 1 == pChars.length) {
                    if (pChars[pi] == '.') {
                        pi++;
                        si++;
                    } else if (pChars[pi] == sChars[si]) {
                        pi++;
                        si++;
                    } else {
                        return false;
                    }
                } else {
                    if (pChars[pi + 1] == '.') {
                        if (pChars[pi] == '.') {
                            pi++;
                            si++;
                        } else {
                            if (pChars[pi] == sChars[si]) {     
                                pi++;
                                si++;
                            } else {
                                return false;
                            }
                        }
                    } else if (pChars[pi + 1] == '*') {                           // case 1: x*
                        if (pChars[pi] == '.') {                           //     case 1.1: .* match everything
                            if (pChars.length > 2) {
                                si = jumpToNextNonDuplicateCharacter(sChars, si, sChars[si]);
                                pi = pi + 2;
                            } else {
                                return true;
                            }
                        } else {                                           //     case 1.2: [letter]* - compare first char
                            if (pChars[pi] == sChars[si]) {
                            	if (pi + 2 == pChars.length) {
                            		si = jumpToNextNonDuplicateCharacter(sChars, si, pChars[pi]);
                            	} else {
                            	
                            		int z = si;
                            		boolean hasMatch = false;
                            		for (; z < jumpToNextNonDuplicateCharacter(sChars, si, pChars[pi]) + 1; z++) {
                            			String subS = aggregrateCharToString(sChars, z);
                            			String subP = aggregrateCharToString(pChars, pi + 2);
                            			if (isMatch(subS, subP) && !subP.isEmpty()) {
                            				hasMatch = true;
                            				break;
                            			}
                            		}
                            		if (hasMatch) {
                            			si = z;
                            		} else {
                            			return false;
                            		}
                            	}
                                
//                                int i = pi + 2;
//                                while (i < pChars.length && pChars[pi] == pChars[i]) {
//                                    i++;
//                                }
//                                pi = i;
                            	 pi = pi + 2;
                            } else {
                                pi = pi + 2;
                            }
                        }
                    } else {                                               // case 2: x. or xy or .y => pi move right 1
                        if (pChars[pi] == '.') {                           //     case 2.1: .y
                            pi++;
                            si++;
                        } else if (pChars[pi] == sChars[si]) {             //     case 2.2: xy or x. => pi move right 1 when same       
                            pi++;
                            si++;
                        } else {
                            return false;
                        }
                    }
                }
            }
            
            if (pi < pChars.length && si == sChars.length) {
            	while (pi < pChars.length) {
            		if (pi + 1 < pChars.length && pChars[pi + 1] == '*' ) {
            			pi = pi + 2;
            		} else if (pi < pChars.length && pChars[pi] == '.') {
            			pi++;
            		} else {
            			return false;
            		}
                }
            }
            
            return (pi == pChars.length && si == sChars.length);
        }
    }
    
    
    public int jumpToNextNonDuplicateCharacter(char[] sChars, int si, char target) { 
        for (int i = si; i < sChars.length; i++) {
            if (sChars[i] == target) {
                continue;
            } else {
                return i;
            }
        }
        return sChars.length;
    }
    
    public String aggregrateCharToString(char[] chars, int current) {
        String result = "";
        for (int i = current; i < chars.length; i++) {
            result = result + chars[i];
        }
        return result;
    }
}
