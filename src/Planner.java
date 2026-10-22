import java.util.Scanner;

public class Planner {
    public static void printMenu(String headline, String option1, String option2, String option3, String option4) {
        System.out.println("\n\n\n===== " + headline + " ===== \n" +
                "1. " + option1 + "\n" +
                "2. " + option2 + "\n" +
                "3. " + option3 + "\n" +
                "4. " + option4 + "");
        System.out.print("Choose an option:");
    }

    public static void showStatistic(int sessions, int totalTime, int lesson1, int lesson2, int lesson3, int lesson4) {
        System.out.println("\n\n\n===== WEEKLY STATISTICS =====\n" +
                "Study sessions: " + sessions + "\n" +
                "Total study time: " + totalTime + " minutes\n" +
                "Programming: " + lesson1 + " minutes\n" +
                "Mathematics: " + lesson2 + " minutes\n" +
                "English: " + lesson3 + " minutes\n" +
                "Other: " + lesson4 + " minutes\n");
    }

    public static void checkGoal(int goalTime, int totalTime) {
        if ((goalTime - totalTime) <= 0) {
            System.out.println("\n\n\nWeekly goal achieved!");
        } else {
            System.out.println("\n\n\nWeekly goal: " + goalTime + " minutes\n" +
                    "You studied: " + totalTime + " minutes\n" +
                    "Remaining: " + (goalTime - totalTime) + " minutes\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weeklyGoalTime = 600;
        int totalStudyTime = 0;
        boolean exitSwitch = true;
        int studySessions = 0;
        int programmingStudyTime = 0;
        int mathStudyTime = 0;
        int engStudyTime = 0;
        int otherStudyTime = 0;
        while (exitSwitch) {
            printMenu("STUDY TRACKER", "Add study session", "View statistics", "Check weekly goal", "Exit");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    printMenu("Choose subject:", "Programming", "Mathematics", "English", "Other");

                    int subject = Integer.parseInt(scanner.nextLine());
                    if (subject < 1 || subject > 4) {
                        System.out.println("Invalid subject. Choose a number from 1 to 4.");
                        break;
                    }
                    System.out.print("\nStudy time in minutes: ");
                    int minutes = Integer.parseInt(scanner.nextLine());
                    if (minutes <= 0) {
                        System.out.println("Invalid study time. Time must be greater than 0.");
                        break;
                    }
                    switch (subject) {
                        case 1:
                            programmingStudyTime += minutes;
                            break;
                        case 2:
                            mathStudyTime += minutes;
                            break;
                        case 3:
                            engStudyTime += minutes;
                            break;
                        case 4:
                            otherStudyTime += minutes;
                            break;
                        default:
                            break;
                    }
                    totalStudyTime += minutes;
                    studySessions++;
                    System.out.println("Study session added!");
                    System.out.println("Current total study time: " + totalStudyTime + " minutes\n");
                    break;
                case 2:
                    showStatistic(studySessions, totalStudyTime, programmingStudyTime, mathStudyTime, engStudyTime,
                            otherStudyTime);
                    break;
                case 3:
                    checkGoal(weeklyGoalTime, totalStudyTime);
                    break;
                case 4:
                    System.out.println("Study tracker closed. Keep up the good work!");
                    exitSwitch = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose a number from 1 to 4.");
                    break;
            }
        }
    }
}
