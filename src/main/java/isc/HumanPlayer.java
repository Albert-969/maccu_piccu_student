package isc;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    // TODO (students):
    // Add any human-specific turn workflow needed by your paper rules.
    // At minimum, this method should complete one turn for this player.
    @Override
    public void takeTurn(DiceGame game) {
        System.out.println("\n" + getName() + "'s turn:");
        game.playTurn(this);
    }

    @Override
    public int getHighScore() {
        return highScore;
    }

    @Override
    public String toString() {
        return "HumanPlayer{name='" + name + "', score=" + turnScore + ", highScore=" + highScore + "}";
    }
}