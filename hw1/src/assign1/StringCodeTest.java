package assign1;// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.


import static org.junit.Assert.*;
import org.junit.Test;

import assign1.StringCode;

public class StringCodeTest {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	 
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("", StringCode.blowup(""));
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
	}
	
	@Test
	public void testBlowup4() {
		// basic cases
		assertEquals("", StringCode.blowup(""));
		assertEquals("444aaaaa", StringCode.blowup("34a4"));
		assertEquals("8888888", StringCode.blowup("78"));
		assertEquals("444aaaaab,: - 444", StringCode.blowup("34ab,: - 34"));
	}
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}
	
	@Test
	public void testRun4() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("435566777555"));
		assertEquals(4, StringCode.maxRun("aaaa3333bbbb"));
		assertEquals(1, StringCode.maxRun("a1b2c3"));
		assertEquals(3, StringCode.maxRun("a1   ,;...b2c3"));
	}
	
	@Test
	public void testStringIntersect1() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(true, StringCode.stringIntersect("abcde", "fgabc", 3));
		assertEquals(false, StringCode.stringIntersect("abcd", "efgh", 2));
		assertEquals(true, StringCode.stringIntersect("ijklmns", "iolkfgklmns", 5));
	}
	
	@Test
	public void testStringIntersect2() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(false, StringCode.stringIntersect("", "", 5));
		assertEquals(true, StringCode.stringIntersect("avfas", "acdeg", 0));
		assertEquals(false, StringCode.stringIntersect("avfas", "", 5));
		assertEquals(true, StringCode.stringIntersect("", "", 0));
	}
	
	@Test
	public void testStringIntersect3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(false, StringCode.stringIntersect("avd", "avdf", 4));
		assertEquals(false, StringCode.stringIntersect("avfd", "avf", 4));
	}
}
