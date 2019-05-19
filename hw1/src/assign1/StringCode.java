package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		
		int ans=0, cnt=1, i=0;
        while (i<str.length()) {

            while ((i < str.length() - 1) && str.charAt(i) == str.charAt(i+1)) {
                cnt++;
                i++;
            }

            if (cnt > ans) {
                ans = cnt;
            }
            cnt = 1;
            i++;
        }
		return ans;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		
		String ans = "";
		for (int i=0; i<str.length()-1; i++) {
			int cnt = str.charAt(i) - '0';
			if (cnt >= 0 && cnt <= 9) {
				char next = str.charAt(i+1);
				for (int j=0; j<cnt; j++) {
					ans += next;
				}
			} else {
				ans += (str.charAt(i));
			}
		}
		if (str.length() == 0) {
			return "";
		}
		if (str.charAt(str.length()-1) - '0' >=0 && str.charAt(str.length()-1) - '0' <=9) {
			return ans;
		}
		return ans + (str.charAt(str.length()-1));
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if (len == 0) {
			return true;
		}
		HashSet<String> hs = new HashSet<String>();
		for (int i=0; i<=b.length()-len; i++) {
			hs.add(b.substring(i, i+len-1));
		}
		for (int i=0; i<=a.length()-len; i++) {
			if (hs.contains(a.substring(i, i+len-1))) {
				return true;
			}
		}
		return false;
	}
	

}
