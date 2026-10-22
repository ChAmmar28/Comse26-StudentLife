import java.util.Scanner;

public class GradeTracker {
    static Scanner scanner = new Scanner(System.in);

    public static String getGrade(double average) {
        if (average >= 90)
            return "A";
        else if (average >= 80)
            return "B";
        else if (average >= 70)
            return "C";
        else if (average >= 60)
            return "D";
        else
            return "F";
    }

    public static void printMenu(String headline, String option1, String option2, String option3, String option4) {
        System.out.println("\n\n\n===== " + headline + " ===== \n" +
                "1. " + option1 + "\n" +
                "2. " + option2 + "\n" +
                "3. " + option3 + "\n" +
                "4. " + option4 + "");
        System.out.print("Choose an option:");
    }

    public static void main(String[] args) {
        double assignmentPoints = 0;
        int assignmentCount = 0;
        double examPoints = 0;
        int examCount = 0;

        boolean running = true;

        while (running) {
            printMenu("SEMESTER GRADE TRACKER", "Add assignment result", "Add exam result", "View current grade",
                    "Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: {
                    System.out.println("Enter assignment score: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    if (score >= 0) {
                        assignmentPoints += score;
                        assignmentCount++;
                        System.out.println("Assignment score added.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter exam score: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    if (score >= 0) {
                        examPoints += score;
                        examCount++;
                        System.out.println("Exam score added.");
                    }
                    break;
                }
                case 3: {
                    if (assignmentCount == 0 && examCount == 0) {
                        System.out.println("No results available yet.");
                        break;
                    }

                    double assignmentAverage = 0;
                    double examAverage = 0;
                    double overallAverage;

                    if (assignmentCount > 0) {
                        assignmentAverage = assignmentPoints / assignmentCount;
                    }
                    if (examCount > 0) {
                        examAverage = examPoints / examCount;
                    }

                    if (assignmentCount > 0 && examCount > 0) {
                        overallAverage = assignmentAverage * 0.50 + examAverage * 0.50;
                    } else if (assignmentCount > 0) {
                        overallAverage = assignmentAverage;
                    } else {
                        overallAverage = examAverage;
                    }

                    System.out.println("===== CURRENT RESULTS =====\n" +
                            "Assignments completed: " + assignmentCount + "\n" +
                            "Assignment average: " + assignmentAverage + "\n" +
                            "Exams completed: " + examCount + "\n" +
                            "Exam average: " + examAverage + "\n" +
                            "Overall average: " + overallAverage + "\n" +
                            "Grade: " + getGrade(overallAverage) + "\n" +
                            "Status: " + (overallAverage >= 60 ? "Passing" : "Not passing") + "\n");

                    break;
                }
                case 4:
                    System.out.println("Grade tracker closed.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number from 1 to 4.");
            }
        }
    }
}