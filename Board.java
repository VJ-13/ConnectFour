public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] grid = new char[NUM_OF_ROW][NUM_OF_COLUMNS];

	public Board() {

		// Initialized
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				grid[i][j] = ' ';
			}
		}

	}

	// Validates the input
	public boolean validate(int x) {
		if (x < 1 || x > 7) {
			return false;
		}

		x = x - 1;
		if (grid[0][x] != ' ') {
			return false;
		} else {
			return true;
		}
	}

	// Adds the piece on to the board
	public void addPiece(char c, int x) {
		x = x - 1;
		for (int i = NUM_OF_ROW - 1; i >= 0; i--) {
			if (grid[i][x] == ' ') {
				grid[i][x] = c;
				break;
			}
		}
	}

	// Removes the piece on the board
	public void remove(int x) {
		x = x - 1;
		for (int i = NUM_OF_ROW - 1; i >= 0; i--) {
			if (grid[i][x] == ' ') {
				grid[i + 1][x] = ' ';
				break;
			}
		}
	}

	// Gets the opponents symbol
	public char opponentsSymbol(char c) {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (grid[i][j] != ' ' && grid[i][j] != c) {
					return grid[i][j];
				}
			}
		}
		return '0';
	}

	// Gets the winning move of the player
	public int winningMove(char c) {
		for (int i = 1; i < NUM_OF_COLUMNS + 1; i++) {
			addPiece(c, i);
			if (containsWin()) {
				remove(i);
				return i;
			}
			remove(i);
		}

		return 0;
	}

	// Prints the board
	public void printBoard() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			System.out.print("|");
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				System.out.print(grid[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

	// Checks for win
	public boolean containsWin() {

		// 4 Across
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS - 3; j++) {
				if (grid[i][j] != ' ') {
					if (grid[i][j] == grid[i][j + 1] && grid[i][j + 1] == grid[i][j + 2]
							&& grid[i][j + 2] == grid[i][j + 3]) {
						return true;
					}
				}

			}
		}

		// 4 Up and Down
		for (int i = 0; i < NUM_OF_ROW - 3; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				if (grid[i][j] != ' ') {
					if (grid[i][j] == grid[i + 1][j] && grid[i + 1][j] == grid[i + 2][j]
							&& grid[i + 2][j] == grid[i + 3][j]) {
						return true;
					}
				}
			}
		}

		// Upwards Diagonal
		for (int i = 0; i < NUM_OF_ROW - 3; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS - 3; j++) {
				if (grid[i][j] != ' ') {
					if (grid[i][j] == grid[i + 1][j + 1] && grid[i + 1][j + 1] == grid[i + 2][j + 2]
							&& grid[i + 2][j + 2] == grid[i + 3][j + 3]) {
						return true;
					}
				}
			}
		}

		// Downwards Diagonal
		for (int i = 0; i < NUM_OF_ROW - 3; i++) {
			for (int j = 3; j < NUM_OF_COLUMNS; j++) {
				if (grid[i][j] != ' ') {
					if (grid[i][j] == grid[i + 1][j - 1] && grid[i + 1][j - 1] == grid[i + 2][j - 2]
							&& grid[i + 2][j - 2] == grid[i + 3][j - 3]) {
						return true;
					}
				}
			}
		}

		return false;
	}

	// Checks for tie
	public boolean isTie() {
		if (grid[0][0] != ' ' && grid[0][1] != ' ' && grid[0][2] != ' ' && grid[0][3] != ' ' && grid[0][4] != ' '
				&& grid[0][5] != ' ' && grid[0][6] != ' ' && !containsWin()) {
			return true;
		}
		return false;
	}

	// Resets the board
	public void reset() {
		for (int i = 0; i < NUM_OF_ROW; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				grid[i][j] = ' ';
			}
		}
	}

}
