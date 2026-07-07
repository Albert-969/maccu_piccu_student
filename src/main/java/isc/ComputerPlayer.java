package isc;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    // TODO (students):
    // Add computer-specific strategy decisions here.
    // The strategy details are part of the paper handout.
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
        return "ComputerPlayer{name='" + name + "', score=" + turnScore + ", highScore=" + highScore + "}";
    }
}