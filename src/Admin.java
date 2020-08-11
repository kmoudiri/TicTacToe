public class Admin {


    public static void main(String[] args) {
        Player randomPlayer= new RandomPlayer();
        Player optimalPlayer = new RandomPlayer();
        GameState state = new GameState(
                4,
                randomPlayer,
                optimalPlayer);

        while (state.getBoard().gameEnded() == false){
            BoardPrinter printer = new BoardPrinter(state);
            printer.printToTerminal();
            state = state.play();


        }
        BoardPrinter printer = new BoardPrinter(state);
        printer.printToTerminal();
        System.out.println("Winner is: " + state.getBoard().winner());
    }
}
