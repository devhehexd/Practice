import java.util.Scanner;

public class PlayerNumberGenerator {

    public int[] generatePlayerNumber() {

        Scanner scanner = new Scanner(System.in);

        int[] playerNumber = new int[4];

        System.out.print("0~9 사이의 정수 4개를 입력해주세요: ");
        int setNumber = scanner.nextInt();

        int mod = 1000;

        for (int i = 0; i < playerNumber.length; i++) {
            playerNumber[i] = setNumber / mod;
            setNumber = setNumber % mod;
            mod = mod / 10;
        }
        return playerNumber;
    }
}
