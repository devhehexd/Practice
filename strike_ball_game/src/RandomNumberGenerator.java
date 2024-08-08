import java.util.Random;

public class RandomNumberGenerator {

    public int[] generateRandomNumber () {

        Random random = new Random();

        int[] randomNumber = new int[4];

        for (int i = 0; i < randomNumber.length; i++) {
            randomNumber[i] = random.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (randomNumber[i] == randomNumber[j]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < randomNumber.length; i++) {
            System.out.print(randomNumber[i]);
            if (i < randomNumber.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();

        return randomNumber;
    }

}

