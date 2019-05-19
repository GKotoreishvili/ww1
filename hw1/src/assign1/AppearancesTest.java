package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}

	@Test
	public void testSameCount3() {
		List<String> a = stringToList("abbddcccr");
		List<String> b = stringToList("cccbbaddfgr");
		assertEquals(5, Appearances.sameCount(a, b));
	}

	@Test
	public void testSameCount4() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("efgfgeds");
		assertEquals(0, Appearances.sameCount(a, b));
	}

	@Test
	public void testSameCount5() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5, 9, 8, 9);
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(3, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 2, 2)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1, 2, 9)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 3, 1, 1, 2, 9)));
	}

}
