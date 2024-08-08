public class Numbers {

    private int[] randomNumber;
    private int[] playerNumber;

    public int[] getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber() {

        PlayerNumberGenerator png = new PlayerNumberGenerator();

        this.playerNumber = png.generatePlayerNumber();
    }

    public int[] getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber() {

        RandomNumberGenerator rng = new RandomNumberGenerator();

        this.randomNumber = rng.generateRandomNumber();
    }
}
