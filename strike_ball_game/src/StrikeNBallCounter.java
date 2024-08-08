public class StrikeNBallCounter {

    private int strike = 0;
    private int ball = 0;
    private int counter = 0;

    public void strikeNBallCounter() {

        Numbers numbers = new Numbers();
        numbers.setRandomNumber();
        numbers.setPlayerNumber();

        for (int i = 0; i < 4; i++) {
            int semiBallCounter = 0;
            for (int j = 0; j < 4; j++) {
                if (numbers.getRandomNumber()[i] == numbers.getPlayerNumber()[j]) {
                    strike++;
                    System.out.println(strike + " 스트라이크 입니다.");
                    break;
                } else {
                    semiBallCounter++;
                    if (semiBallCounter == 4) {
                        ball++;
                        System.out.println(ball + " 볼 입니다.");
                    }
                }
            }
            counter++;
            System.out.println("카운트 " + counter + " 입니다.");
        }

    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getCounter() {
        return counter;
    }
}
