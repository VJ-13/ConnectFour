import java.util.Scanner;

public class ConnectFour {

	// Initializing the objects
	private Player player1;
	private Player player2;
	private boolean isP1Turn;
	private Board board;

	// Constructor
	public ConnectFour(Board board) {
		this.board = board;
		isP1Turn = true;
	}

	// Setters
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void playGame() {
		board.reset();
		board.printBoard();
		while (!gameIsOver()) {
			System.out.println("It is " + getCurrentPlayer().getName() + "'s turn.");
			getCurrentPlayer().makeMove(board);
			board.printBoard();
			changeTurns();
		}
		if (board.containsWin()) {
			changeTurns();
			System.out.println("Congratulations " + getCurrentPlayer().getName() + ", you have won!");
		} else {
			System.out.println("The game is a tie. You both lose.");
		}
	}

	private boolean gameIsOver() {
		return board.containsWin() || board.isTie();
	}

	private Player getCurrentPlayer() {
		if (isP1Turn) {
			return player1;
		}
		return player2;
	}

	private void changeTurns() {
		isP1Turn = !isP1Turn;
	}

	public static void main(String[] args) {
		// Initializing
		int choose;
		String player1;
		Scanner scan = new Scanner(System.in);
		Board board = new Board();
		ConnectFour game = new ConnectFour(board);

		System.out.println("Welcome to Connect Four");

		do {
			System.out.println(
					"If you want to play with AI enter 1 or if you want to play with another person enter 2: ");
			choose = scan.nextInt();
		} while (choose < 1 || choose > 2);

		// Player 1 Setup
		System.out.println("Player 1 Name: ");
		player1 = scan.next();
		game.setPlayer1(new HumanPlayer(player1.charAt(0), board, player1));

		// Player 2 Setup
		if (choose == 1) {
			System.out.println("AI is selected");
			game.setPlayer2(new AIPlayer('A', board, "AI"));
		} else {
			String player2;
			System.out.println("Player 2 Name: ");
			player2 = scan.next();
			game.setPlayer2(new HumanPlayer(player2.charAt(0), board, player2));
		}

		game.playGame();
	}
}
