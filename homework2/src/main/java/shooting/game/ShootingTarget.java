package shooting.game;

import java.util.Random;
import java.util.Scanner;

public class ShootingTarget {
    public static void main(String[] args) {
        String[][] target = new String[6][6];
        initialSquare(target);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int firstIndex = random.nextInt(5) + 1;
        int secondIndex = random.nextInt(5) + 1;
        System.out.println(firstIndex + " " + secondIndex);

        System.out.println("All set. Get ready to rumble!\n");

        while (true) {
            System.out.print("Enter first index: ");
            int enFirstIndex = scanner.nextInt();
            if (enFirstIndex > target.length - 1) {
                System.out.println("Entered index greater than length, Try again!");
                continue;
            }

            System.out.print("Enter second index: ");
            int enSecondIndex = scanner.nextInt();
            if (enSecondIndex > target.length - 1) {
                System.out.println("Entered index greater than length, Try again!");
                continue;
            }

            if (enFirstIndex == firstIndex && enSecondIndex == secondIndex) {
                target[firstIndex][secondIndex] = "X";
                printArray(target);
                System.out.println("You have won");
                break;
            } else {
                missedShot(target, enFirstIndex, enSecondIndex);
                printArray(target);
                System.out.println("Try again");
            }
        }
    }
    public static void initialSquare(String[][] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                target[0][j] = String.valueOf(j);
                target[i][0] = String.valueOf(i);
                if (i != 0 && j != 0) {
                    target[i][j] = "-";
                }
                System.out.print(target[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public static String[][] missedShot(String[][] arr, int x, int y) {
        arr[x][y] = "*";
        return arr;
    }
}
