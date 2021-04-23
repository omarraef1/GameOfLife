/**
 * The model for John Conway's Game of Life.
 *
 * This class has all needed methods as stubs.
 * 
 * Comments explain each method what each method does.
 *
 * @author Rick Mercer and Omar R. Gebril
 */
public class GameOfLife {
	/**
	 * Write the constructor so it takes two integer arguments to represent the
	 * number of rows and columns in the game of life. The constructor creates a
	 * society with no cells but space to store rows*cols cells.
	 *
	 * @param rows
	 *            The height of the grid that shows the cells.
	 * @param cols
	 *            The width of the grid that shows the cells.
	 */

	private boolean[][] grid;

	public GameOfLife(int rows, int cols) {
		grid = new boolean[rows][cols];
	}

	/**
	 * Return the number of rows, which can be indexed from 0..numberOfRows()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfRows() {
		return grid.length;
	}

	/**
	 * The number of columns, which can be indexed from 0..numberOfColumns()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfColumns() {
		return grid[0].length;
	}

	/**
	 * Place a new cell in the society.
	 * 
	 * @param row
	 *            The row to grow the cell.
	 * @param col
	 *            The column to grow the cell.
	 *
	 *            Precondition: row and col are in range.
	 */
	public void growCellAt(int row, int col) {
		grid[row][col] = true;
	}

	/**
	 * 5) Return true if there is a cell at the given row and column. Return false
	 * if there is none at the specified location.
	 *
	 * @param row
	 *            The row to check.
	 * @param col
	 *            The column to check.
	 * @return True if there is a cell at the given row or false if none
	 *
	 *         Precondition: row and col are in range.
	 */
	public boolean cellAt(int row, int col) {
		return grid[row][col] == true;
	}

	/**
	 * Return one big string of cells to represent the current state of the society
	 * of cells (see output below where '.' represents an empty space and 'O' is a
	 * live cell. There is no need to test toString. Simply use it to visually
	 * inspect if needed. Here is one sample output from toString:
	 *
	 * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
	 * society.growCellAt(2, 3); society.growCellAt(3, 4);
	 * System.out.println(society.toString());
	 *
	 * @return A textual representation of this society of cells.
	 */
	// Sample Output:
	// ..............
	// ..O...........
	// ...O..........
	// ....O.........
	@Override
	public String toString() {
		String str = "";
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == false) {
					str += ".";
				} else if (grid[row][col] == true) {
					str += "O";
				}
			}
			str += "\n";
		}
		// System.out.print(str);
		return str;
	}

	/**
	 * The return values should always be in the range of 0 through 8.
	 *
	 * @return The number of neighbors around any cell using wrap around.
	 * 
	 *         Precondition: row and col are in range.
	 *
	 *         Count the neighbors around the given location. Use wraparound. A cell
	 *         in row 0 has neighbors in the last row if a cell is in the same
	 *         column, or the column to the left or right. In this example, cell 0,5
	 *         has two neighbors in the last row, cell 2,8 has four neighbors, cell
	 *         2,0 has four neighbors, cell 1,0 has three neighbors. The cell at 3,8
	 *         has 3 neighbors. The potential location for a cell at 4,8 would have
	 *         three neighbors.
	 */
	// .....O..O
	// O........
	// O.......O
	// O.......O
	// ....O.O..
	public int neighborCount(int row, int col) {
		int count = 0;

		int colLeft = col - 1;
		int colRight = col + 1;
		int rowAbove = row - 1;
		int rowBelow = row + 1;

		if (colLeft == -1) {
			colLeft = grid[0].length - 1;
		}
		if (colRight == grid[0].length) {
			colRight = 0;
		}
		if (rowAbove == -1) {
			rowAbove = grid.length - 1;
		}
		if (rowBelow == grid.length) {
			rowBelow = 0;
		}

		if (grid[row][colRight] == true) {
			count++;
		}
		if (grid[row][colLeft] == true) {
			count++;
		}
		if (grid[rowAbove][col] == true) {
			count++;
		}
		if (grid[rowBelow][col] == true) {
			count++;
		}

		if (grid[rowAbove][colRight] == true) {
			count++;
		}
		if (grid[rowAbove][colLeft] == true) {
			count++;
		}
		if (grid[rowBelow][colLeft] == true) {
			count++;
		}
		if (grid[rowBelow][colRight] == true) {
			count++;
		}

		return count;
	}

	/**
	 * Update the state to represent the next society. Typically, some cells will
	 * die off while others are born.
	 */
	public void update() {
		boolean[][] temp = new boolean[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == false && neighborCount(row, col) == 3) {
					temp[row][col] = true;
				} else if (grid[row][col] == true && (neighborCount(row, col) == 2 || neighborCount(row, col) == 3)) {
					temp[row][col] = true;
				} else if (grid[row][col] == true && neighborCount(row, col) < 2) {
					temp[row][col] = false;
				} else if (grid[row][col] == true && neighborCount(row, col) > 3) {
					temp[row][col] = false;
				}
			}
		}
		grid = temp;
	}
}