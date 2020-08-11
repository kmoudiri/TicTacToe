import java.util.Collection;

public class BoardPrinter {

    private final GameState state;

    public BoardPrinter(GameState state) {

        this.state = state;
    }

    public void printToTerminal() {
        Flag[][] boardArray = new Flag[state.getSize()][state.getSize()];

        for(Flag oneOfTheFlags : Flag.values()) {
            Collection<Square> squaresOfFlag = state.getBoard().getSquaresOf(oneOfTheFlags);
            squaresOfFlag.forEach( (Square square)->boardArray[square.getX()][square.getY()]=oneOfTheFlags);
        }

        for (int i=0; i<state.getSize();i++){
            for (int j=0; j<state.getSize(); j++){
                if(boardArray[i][j] != null) {
                    System.out.print(boardArray[i][j]);
                } else {
                    System.out.print(" ");
                }
                if(j<state.getSize()-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            for(int j=0;j<state.getSize()*2-1;j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
