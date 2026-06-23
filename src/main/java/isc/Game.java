package isc;

@SuppressWarnings("unused")
public class Game implements DiceGame {
    private boolean base;
    private boolean middle;
    private boolean top;
    private final Menu menu;

    public Game() {
        this.menu = new Menu();
        resetFlags();
    }

    public Game(Menu menu) {
        this.menu = menu;
        resetFlags();
    }

    public void resetFlags() {
        this.base = false;
        this.middle = false;
        this.top = false;
    }

    // TODO (students):
    // 1) Build complete match flow.
    // 2) Validate inputs.
    // 3) Reset the right state at the right time.
    // 4) Use determineWinnerTurn and determineWinnerMatch at the correct points.
    @Override
    public void playGame(String playerName, int numTurns) {
        throw new UnsupportedOperationException("TODO: implement playGame");
    }

    // TODO (students):
    // Implement one complete turn and apply the paper rules for scoring.
    @Override
    public void playTurn(Player player) {
        throw new UnsupportedOperationException("TODO: implement playTurn");
    }

    private void determineWinner(Player player1, int score1, Player player2, int score2) {
        if (score1 > score2) {
            System.out.println(player1.getName() + " wins with a score of " + score1 + " against " + player2.getName() + "'s score of " + score2);
        } else if (score2 > score1) {
            System.out.println(player2.getName() + " wins with a score of " + score2 + " against " + player1.getName() + "'s score of " + score1);
        } else {
            System.out.println("It's a tie!");
        }
    }

    // TODO (students):
    // Extend this if your paper instructions require extra turn-level side effects.
    @Override
    public void determineWinnerTurn(Player player1, Player player2) {
        determineWinner(player1, player1.getTurnScore(), player2, player2.getTurnScore());
    }

    // TODO (students):
    // Extend this if your paper instructions require extra match-level side effects.
    @Override
    public void determineWinnerMatch(Player player1, Player player2) {
        determineWinner(player1, player1.getMatchScore(), player2, player2.getMatchScore());
    }
}
