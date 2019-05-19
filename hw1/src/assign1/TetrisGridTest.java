package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class TetrisGridTest {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	@Test
	public void testClear1() {
		boolean[][] before =
		{
			{true, true, false, },
			{false, true, true, }
		};

		boolean[][] after =
		{
			{true, false, false},
			{false, true, false}
		};

		assign1.TetrisGrid tetris = new assign1.TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}

	@Test
	public void testClear2() {
		boolean[][] before =
				{
						{true, true, true, false, true, false},
						{true, true, true, true, false, false},
						{true, false, true, true, false, false}
				};

		boolean[][] after =
				{
						{true, false, true, false, false, false},
						{true, true, false, false, false, false},
						{false, true, false, false, false, false}
				};

		assign1.TetrisGrid tetris = new assign1.TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
}
