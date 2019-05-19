//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {

	private boolean[][] Grid;
	private int rows;
	private int columns;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {

		rows = grid.length;
		columns = grid[0].length;
		Grid = new boolean[rows][columns];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				Grid[i][j] = grid[i][j];
			}
		}
	}

	private void update(int ind){

		for (int i=0; i<rows; i++) {
			for (int j=ind; j<columns-1; j++) {
				Grid[i][j] = Grid[i][j + 1];
				Grid[i][j + 1] = false;
			}
		}
	}
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {

		int i=0, cnt = 0;
		while (cnt < columns) {
			int j=0, sent=0;
			while (j<(rows-1)) {
				if (Grid[j][i] != Grid[j+1][i]) {
					sent++;
					break;
				}
				j++;
			}
			if (sent == 0) {
				update(i);
			} else {
				i++;
			}
			cnt++;
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	public boolean[][] getGrid() {
		return Grid;
	}
}
