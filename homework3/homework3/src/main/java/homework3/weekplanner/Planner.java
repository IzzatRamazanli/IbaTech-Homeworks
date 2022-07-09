package homework3.weekplanner;

import java.util.Scanner;

public class Planner {
    public static void main(String[] args) {
        String[][] plans = new String[7][2];
        plansFiller(plans);

        Scanner scanner = new Scanner(System.in);

        boolean check = true;

        while (check) {
            System.out.print("Enter day of Week: ");
            String day = scanner.nextLine();

            if (day.startsWith("change")) {
                day = textFormatter(day.substring(7)); //extract day from input
                changePlan(plans, day); //assigning new plan to day
                continue;
            } else {
                day = textFormatter(day); // formatting the user input
            }

            if (day.equals("Exit")) {
                System.out.println("Leaving..");
                check = false;
            } else {
                switchPlans(plans, day);
            }

        }

    }

    public static void plansFiller(String[][] plans) {

        plans[0][0] = "Sunday";
        plans[0][1] = "do homework";

        plans[1][0] = "Monday";
        plans[1][1] = "go to courses, watch a film";

        plans[2][0] = "Tuesday";
        plans[2][1] = "do exercises";

        plans[3][0] = "Wednesday";
        plans[3][1] = "do coding";

        plans[4][0] = "Thursday";
        plans[4][1] = "go to course";

        plans[5][0] = "Friday";
        plans[5][1] = "walk outside";

        plans[6][0] = "Saturday";
        plans[6][1] = "go shopping";

    }

    public static void switchPlans(String[][] plans, String day) {
        switch (day) {
            case "Monday":
                System.out.println("Your task for " + day + " " + plans[1][1]);
                break;
            case "Tuesday":
                System.out.println("Your task for " + day + " " + plans[2][1]);
                break;
            case "Wednesday":
                System.out.println("Your task for " + day + " " + plans[3][1]);
                break;
            case "Thursday":
                System.out.println("Your task for " + day + " " + plans[4][1]);
                break;
            case "Friday":
                System.out.println("Your task for " + day + " " + plans[5][1]);
                break;
            case "Saturday":
                System.out.println("Your task for " + day + " " + plans[6][1]);
                break;
            case "Sunday":
                System.out.println("Your task for " + day + " " + plans[0][1]);
                break;
            case "All plans":
                printPlans(plans);
                break;
            default: {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }
    }

    public static void printPlans(String[][] plans) {
        for (int i = 0; i < plans.length; i++) {
            for (int j = 0; j < plans[i].length; j++) {
                if (plans[i][j] != null) {
                    System.out.print(plans[i][j] + " | ");
                }
            }
            System.out.println();
        }
    }//show all plans at once

    public static String textFormatter(String text) {
        text = text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase().trim();
        return text;
    }

    public static String[][] changePlan(String[][] plans, String day) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < plans.length; i++) {
            for (int j = 0; j < plans[i].length; j++) {
                if (day.equals(plans[i][j])) {
                    System.out.println("Current task for " + day + " " + plans[i][1]);
                    break;
                }
            }
        }
        System.out.print("Please, input new tasks for " + day + ": ");
        String newPlan = scanner.nextLine();

        for (int i = 0; i < plans.length; i++) {
            for (int j = 0; j < plans[i].length; j++) {
                if (day.equals(plans[i][j])) {
                    plans[i][1] = newPlan;
                    System.out.println("Your new task for " + day + " successfully assigned!");
                    break;
                }
            }
        }
        return plans;
    }

}
