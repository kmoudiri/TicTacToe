import java.util.*;
import java.util.function.Predicate;

public class Board {
    private final int size;
    private ImmutableHashSet<Square> xSquares = new ImmutableHashSet<>();
    private ImmutableHashSet<Square> oSquares = new ImmutableHashSet<>();
    private ImmutableHashSet<Square> emptySquares = new ImmutableHashSet<>();

    public Board(int size) {
        this.size = size;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                emptySquares.add(new Square(i,j));
            }
        }
        emptySquares.makeImmutable();
        xSquares.makeImmutable();
        oSquares.makeImmutable();
    }

    public boolean gameEnded() {
        if (emptySquares.size() == 0 || winner() != null) {
            return true;
        }
        return false;
    }

    private boolean existsTicTacToeLine(Flag flag, int line) {
        return existsTicTacToe(flag, (Square square) -> square.getX() == line);
    }

    private boolean existsTicTacToeColunm(Flag flag, int colunm) {
        return existsTicTacToe(flag, (Square square) -> square.getY() == colunm);
    }

    private boolean existsTicTacToeDiagonal(Flag flag) {
        return existsTicTacToe(flag, (Square square) -> square.getY() == square.getX());
    }

    private boolean existsTicTacToeReverseDiagonal(Flag flag) {
        return existsTicTacToe(flag, (Square square) -> (square.getY() + square.getX() == size - 1));
    }


    private boolean existsTicTacToe(Flag flag, Predicate<Square> condition) {
        int counter = 0;
        Set<Square> flagSquares;
        if(flag == Flag.X) {
            flagSquares = xSquares;
        } else {
            flagSquares = oSquares;
        }

        for (Square square: flagSquares) {
            if (condition.test(square)){
                counter++;
            }
        }
        return counter == size;
    }

    public Flag winner() {
        for (Flag flag: Flag.values()) {
            for (int i = 0; i<size; i++) {
                if (existsTicTacToeLine(flag, i) || existsTicTacToeColunm(flag, i)) {
                    return flag;
                }
            }
            if (existsTicTacToeDiagonal(flag) || existsTicTacToeReverseDiagonal(flag)) {
                return flag;
            }
        }
        return null;
    }

    public Board play(Flag flag, Square square){
        Board board = new Board(size);

        board.emptySquares = new ImmutableHashSet<>(this.emptySquares);
        board.oSquares = new ImmutableHashSet<>(this.oSquares);
        board.xSquares = new ImmutableHashSet<>(this.xSquares);


        board.emptySquares.remove(square);
        if (flag == Flag.X){
            board.xSquares.add(square);
        }else {
            board.oSquares.add(square);
        }

        board.emptySquares.makeImmutable();
        board.oSquares.makeImmutable();
        board.xSquares.makeImmutable();

        return board;
    }

    public Collection<Square> getSquaresOf(Flag flag) {
        if(flag == null) {
            return emptySquares;
        }
        if (flag == Flag.X) {
            return xSquares;
        }else {
            return oSquares;
        }
    }

}
