public class GameState {
    private final int size;
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private final Flag turn;

    private GameState(int size, Player playerX, Player playerO, Flag turn, Board board) {
        this.size = size;
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = board;
        this.turn = turn;
    }

    public GameState(int size, Player playerX, Player playerO) {
        this.size = size;
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new Board(size);
        this.turn = Flag.X;
    }


    public Board getBoard() {
        return board;
    }

    public Flag getTurn() {
        return turn;
    }

    public GameState play() {
        Square decision;
        if (turn == Flag.X) {
            decision = playerX.decide(this);

        } else {
            decision = playerO.decide(this);
        }
        GameState newGameState =
                new GameState(size,
                        playerX,
                        playerO,
                        turn.getNextTurn(),
                        board.play(turn,decision)
                );
        return newGameState;
    }

    public int getSize() {
        return size;
    }
}
