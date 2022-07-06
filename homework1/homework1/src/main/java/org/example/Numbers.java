package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String gamerName = scanner.nextLine();

        Random random = new Random();
        int randomNumber = random.nextInt(100);

        boolean check = true;
        int[] numberContainer = new int[100];
        int numberIndex = 0;

        System.out.println("Hello " + gamerName + " you must enter numbers in rage 0-100");
        System.out.println("Let's begin!");

        while (check) {

            System.out.print("Enter number: ");
            int gamerNumber = scanner.nextInt();

            numberIndex++;
            numberContainer[numberIndex] = gamerNumber;

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
            }
            if (gamerNumber > randomNumber) {
                System.out.println("Your number is too big. Please, try again.");
            }
            if (gamerNumber < randomNumber) {
                System.out.println("Your number is too small. Please, try again.");
            }
        }
    }
}
