import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {
        Scanner scan = new Scanner(System.in);
        int num;
        // Ask the user for input
        do {
            System.out.println(name + ", please input your move (1 to 7): ");
            // Stores the value
            num = scan.nextInt();

        } while (!board.validate(num));

        // Adds the piece on the board
        board.addPiece(symbol, num);

    }

}
