import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public void makeMove(Board board) {
        Random rand = new Random();
        int num;

        // Checks if there is a winning move for AI
        if (board.winningMove(symbol) != 0) {
            num = board.winningMove(symbol);
        }

        // Checks if there is a winning move for Player
        else if (board.winningMove(board.opponentsSymbol(symbol)) != 0) {
            num = board.winningMove(board.opponentsSymbol(symbol));
        }

        else {
            // Chooses a random column to place the piece
            do {
                num = rand.nextInt(6) + 1;
            } while (!board.validate(num));
        }

        // Adds the piece
        board.addPiece(symbol, num);

    }

}
