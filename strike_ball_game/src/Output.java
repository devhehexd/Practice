public class Output {

    public void output() {

        StrikeNBallCounter snb = new StrikeNBallCounter();

        while (true) {

            snb.strikeNBallCounter();

            if (snb.getStrike() >= 3) {
                System.out.println(snb.getStrike() + " 스트라이크 입니다! 축하합니다!");
                break;
            }

            if (snb.getBall() >= 4) {
                System.out.println(snb.getBall() + " 볼 입니다. 실패하셨습니다.");
                break;
            }

            if (snb.getCounter() >= 7) {
                System.out.println(snb.getCounter() + "카운트 내에 맞추지 못하셨습니다.");
                break;
            }

        }
    }
}
