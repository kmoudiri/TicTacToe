import java.util.Collection;

public class RandomPlayer implements Player {
    @Override
    public Square decide(GameState gameState) {
        Collection<Square> squaresOf = gameState.getBoard().getSquaresOf(null);

        return squaresOf.stream()
                .skip((int) (squaresOf.size() * Math.random()))
                .findFirst()
                .get();
    }
}
