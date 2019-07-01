import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    private final Map<Position, String> board;
    private String lastPlayer;

    public TicTacToe() {
        this.board = new HashMap<Position, String>();
    }

    public void play(String player, Position position) throws PlayerNotAllowedException, PositionTakenException {
        if (this.lastPlayer == player)
            throw new PlayerNotAllowedException();

        if (this.board.containsKey(position))
            throw new PositionTakenException();

        this.lastPlayer = player;

        this.board.put(position, this.lastPlayer);
    }

    public String winner() {
        String winner = this.determineWinnerByRow(0);

        if (winner == null)
            winner = this.determineWinnerByColumn(0);

        if (winner == null)
            winner = this.determineWinnerDiagonally();

        return winner;
    }

    private String determineWinnerDiagonally() {
        if (match(Position.create(0, 0), Position.create(1, 1), Position.create(2, 2)))
            return this.board.get(Position.create(0, 0));

        if (match(Position.create(0, 2), Position.create(1, 1), Position.create(2, 0)))
            return this.board.get(Position.create(0, 2));

        return null;
    }

    private String determineWinnerByColumn(int column) {
        if (match(Position.create(0, column), Position.create(1, column), Position.create(2, column)))
            return this.board.get(Position.create(0, column));

        if (column < 3)
            return determineWinnerByColumn(column + 1);

        return null;
    }

    private String determineWinnerByRow(int row) {
        if (match(Position.create(row, 0), Position.create(row, 1), Position.create(row, 2)))
            return this.board.get(Position.create(row, 0));

        if (row < 3)
            return determineWinnerByRow(row + 1);

        return null;
    }

    private boolean match(Position positionOne, Position positionTwo, Position positionThree) {
        String playerPositionOne = this.board.get(positionOne);
        String playerPositionTwo = this.board.get(positionTwo);
        String playerPositionThree = this.board.get(positionThree);

        return playerPositionOne != null &&
                playerPositionTwo != null &&
                playerPositionThree != null &&
                playerPositionOne == playerPositionTwo &&
                playerPositionOne == playerPositionThree;
    }
}
