package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        System.out.println("Let the game begin!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String gamerName = scanner.nextLine();

        Random random = new Random();
        int randomNumber = random.nextInt(100);

        boolean check = true;
        int[] numberContainer = new int[101];
        int numberIndex = 0;

        System.out.println("Hello " + gamerName + " you must enter numbers in rage 0-100");

        while (check) {

            System.out.print("Enter number: ");
            int gamerNumber = scanner.nextInt();

            if (gamerNumber > 100 || gamerNumber < 0) {
                System.out.println("Number not valid");
                continue;
            }
            boolean numberChecker = true;

            for (int numbers : numberContainer) {
                if (numbers == gamerNumber) {
                    numberChecker = false;
                    break;
                }
            }

            if (numberChecker){
                numberContainer[numberIndex++]=gamerNumber;
            }else {
                System.out.println("Already checked");
                continue;
            }

            if (gamerNumber == randomNumber) {
                System.out.println("Congratulations, " + gamerName + "!");
                System.out.print("Your numbers: ");

                for (int i = 0; i < numberContainer.length; i++) {
                    Arrays.sort(numberContainer);
                    if (numberContainer[i] != 0) {
                        System.out.print(numberContainer[i] + " ");
                    }
                }
                check = false;
            } else if (gamerNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.println("Your number is too small. Please, try again.");
            }
        }
    }
}
