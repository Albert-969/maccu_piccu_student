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
        boolean playAgain = true;
        while (playAgain) {
            menu.displayMenu();
            int choice = menu.getUserChoice();
            if (choice == 2) {
                System.out.println("Exiting game...");
                return;
            }
            String name = menu.getPlayerName();
            if (name.trim().isEmpty()) {
                name = playerName;
            }
            Player human = new HumanPlayer(name);
            Player computer = new ComputerPlayer("Computer");
            human.resetMatchScore();
            computer.resetMatchScore();
            for (int turn = 1; turn <= numTurns; turn++) {
                System.out.println("\n========== Turn " + turn + " ==========");
                human.takeTurn(this);
                computer.takeTurn(this);
                human.setMatchScore();
                computer.setMatchScore();
                System.out.println("\nTurn " + turn + " result:");
                determineWinnerTurn(human, computer);
                System.out.println("Current match score:");
                System.out.println(human.getName() + ": " + human.getMatchScore());
                System.out.println(computer.getName() + ": " + computer.getMatchScore());
                menu.continueGame();
            }
            System.out.println("\n========== Final Result ==========");
            determineWinnerMatch(human, computer);
            System.out.println(human.getName() + " final score: " + human.getMatchScore());
            System.out.println(computer.getName() + " final score: " + computer.getMatchScore());
            playAgain = menu.askToPlayAgain();
        }
        System.out.println("Thank you for playing!");
    }

    // TODO (students):
    // Implement one complete turn and apply the paper rules for scoring.
    @Override
    public void playTurn(Player player) {
        resetFlags();
        player.resetTurnScore();
        int turnScore = 0;
        int[][] rolls = Dice.getDice();
        for (int rollIndex = 0; rollIndex < rolls.length; rollIndex++) {
            int[] currentRoll = rolls[rollIndex];
            System.out.print("Roll " + (rollIndex + 1) + ": ");
            for (int die : currentRoll) {
                System.out.print(die + " ");
            }
            System.out.println();
            for (int diceIndex = 0; diceIndex < currentRoll.length; diceIndex++) {
                int die = currentRoll[diceIndex];
                if (!base && die == 6) {
                    base = true;
                    System.out.println("Base found");
                } else if (base && !middle && die == 3) {
                    middle = true;
                    System.out.println("Middle found");
                } else if (base && middle && !top && die == 1) {
                    top = true;
                    System.out.println("Top found");
                    for (int remainingDice = diceIndex + 1; remainingDice < currentRoll.length; remainingDice++) {
                        turnScore += currentRoll[remainingDice];
                    }
                } else if (top) {
                    turnScore += die;
                }
            }
        } if (!top) {
            turnScore = 0;
            System.out.println("Base-Middle-Top not completed. Score is 0.");
        }
        player.setTurnScore(turnScore);
        System.out.println(player.getName() + "'s turn score: " + turnScore);
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