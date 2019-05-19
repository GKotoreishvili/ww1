// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] Grid;
	private int rows;
	private int columns;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {

		rows = grid.length;
		columns = grid[0].length;
		this.Grid = new char[rows][columns];
		for (int i=0; i<rows; i++) {
			for (int j =0; j<columns; j++) {
				this.Grid[i][j] = grid[i][j];
			}
		}
	}
	
	private int max(int val1, int val2) {
		if (val1 > val2) {
			return val1;
		}
		return val2;
	}
	
	private int min(int val1, int val2) {
		if (val1 < val2) {
			return val1;
		}
		return val2;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {

		int sent=0, maxrow=-1, maxcol=-1, minrow=rows, mincol=columns;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				if (Grid[i][j] == ch) {
					sent++;
					maxrow = max(maxrow, i);
					maxcol = max(maxcol, j);
					minrow = min(minrow, i);
					mincol = min(mincol, j);
				}
			}
		}
		if (sent == 0) {
			return 0;
		}
		return (maxrow - minrow + 1) * (maxcol - mincol + 1);
	}

	private int upLength(int ind1, int ind2) {
		int cnt=0;
		while (ind1 > 0 && Grid[ind1][ind2] == Grid[ind1-1][ind2]) {
			cnt++;
			ind1--;
		}
		return cnt+1;
	}
	
	private int downLength(int ind1, int ind2) {
		int cnt=0;
		while (ind1 < Grid.length-1 && Grid[ind1][ind2] == Grid[ind1+1][ind2]) {
			cnt++;
			ind1++;
		}
		return cnt+1;
	}
	
	private int leftLength(int ind1, int ind2) {
		int cnt=0;
		while (ind2 > 0 && Grid[ind1][ind2] == Grid[ind1][ind2-1]) {
			cnt++;
			ind2--;
		}
		return cnt+1;
	}
	
	private int rightLength(int ind1, int ind2) {
		int cnt=0;
		while (ind2 < Grid[0].length-1 && Grid[ind1][ind2] == Grid[ind1][ind2+1]) {
			cnt++;
			ind2++;
		}
		return cnt+1;
	}
	
	private boolean check(int up, int down, int left, int right) {
		if (up != down) {
			return false;
		}
		if (left != down) {
			return false;
		}
		if (right != left) {
			return false;
		}
		if (up < 2 || down < 2 || left < 2 || right < 2) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {

		int up=0, down=0, left=0, right=0, cnt=0;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				up = upLength(i, j);
				down = downLength(i, j);
				left = leftLength(i, j);
				right = rightLength(i, j);
				if (check(up, down, left, right)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}
