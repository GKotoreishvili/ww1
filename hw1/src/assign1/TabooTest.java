// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TabooTest {

    private List<String> stringToList(String s) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
            // note: String.valueOf() converts lots of things to string form
        }
        return list;
    }

    private List<String> stringToList2(String s) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<s.length(); i++) {
            if (i == s.length()/2) list.add(null);
            list.add(String.valueOf(s.charAt(i)));
            // note: String.valueOf() converts lots of things to string form
        }
        return list;
    }

    private Set<String> stringToSet(String s){
        Set<String> set = new HashSet<String>();
        for (int i=0; i<s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }
        return set;
    }

    @Test
    public void testNoFollow1() {
        List<String> a = stringToList("acab");
        Set<String> ans = stringToSet("cb");
        Taboo<String> t = new Taboo<String>(a);
        assertEquals(ans, t.noFollow("a"));
    }

    @Test
    public void testNoFollow2() {
        List<String> a = stringToList("acab");
        Set<String> ans = stringToSet("");
        Taboo<String> t = new Taboo<String>(a);
        assertEquals(ans, t.noFollow("x"));
    }

    @Test
    public void testNoFollow3() {
        List<String> a = stringToList2("abcd");
        Set<String> ans = stringToSet("");
        Taboo<String> t = new Taboo<String>(a);
        assertEquals(ans, t.noFollow("b"));
    }

    @Test
    public void testReduce1() {
        List<String> a = stringToList("acab");
        List<String> test = stringToList("acbxca");
        List<String> ans = stringToList("axc");
        Taboo<String> t = new Taboo<String>(a);
        t.reduce(test);
        assertEquals(ans, test);
    }

    @Test
    public void testReduce2() {
        List<String> a = stringToList2("acab");
        List<String> test = stringToList("cabd");
        List<String> ans = stringToList("cad");
        Taboo<String> t = new Taboo<String>(a);
        t.reduce(test);
        assertEquals(ans, test);
    }

    @Test
    public void testReduce3() {
        List<String> a = stringToList2("acabed");
        List<String> test = stringToList("edvxfad");
        List<String> ans = stringToList("evxfad");
        Taboo<String> t = new Taboo<String>(a);
        t.reduce(test);
        assertEquals(ans, test);
    }

}
