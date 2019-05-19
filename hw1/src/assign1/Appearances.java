package assign1;

import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {

		int ans=0;
		Map<T, Integer> mp = new HashMap<T, Integer>();
		for (T elem : a) {
			int count=0;
			if (!mp.containsKey(elem)) {
				for (T el : a){
					if (elem.equals(el))
						count++;
				}
				mp.put(elem, count);
			}
		}

		for (Map.Entry<T, Integer> entry : mp.entrySet()) {
			int count=0;
			for (T el : b){
				if (entry.getKey().equals(el))
					count++;
			}
			if (count == entry.getValue()) ans++;
		}
		return ans;
	}
	
}
