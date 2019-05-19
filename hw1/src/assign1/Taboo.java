package assign1;/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {

	private List<T> Rules;

	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {

		Rules = new ArrayList<T>();
		for (T elem : rules) {
			Rules.add(elem);
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {

		Set<T> noFollows = new HashSet<T>();
		int sent=0;
		for (T el : Rules) {
			if (el == null) {
				sent = 0;
				continue;
			}
			if (sent == 1) {
				noFollows.add(el);
			}
			if ((el.equals(elem))) {
				sent++;
			} else sent = 0;
		}
		return noFollows;
	}

	private boolean check(T elem1, T elem2) {

		for (int i=0; i<Rules.size()-1; i++) {
			if (Rules.get(i) == null || Rules.get(i + 1) == null) continue;
			if (Rules.get(i).equals(elem1) && Rules.get(i + 1).equals(elem2)) return true;
		}
		return false;
	}

	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		int count=1, ind=1;
		int size = list.size();
		while (count < size) {
			if (check(list.get(ind-1), list.get(ind))) {
				list.remove(ind);
			} else {
				ind++;
			}
			count++;
		}
	}
}
