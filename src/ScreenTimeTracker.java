import java.util.Scanner;

public class ScreenTimeTracker {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int socialMediaTime = 0;
        int gamingTime = 0;
        int studyingTime = 0;
        int streamingTime = 0;
        int totalScreenTime = 0;
        int sessions = 0;

        boolean running = true;

        while (running) {
            System.out.println("===== SCREEN-TIME TRACKER =====\n" +
                    "1. Add social media time\n" +
                    "2. Add gaming time\n" +
                    "3. Add studying time\n" +
                    "4. Add video or streaming time\n" +
                    "5. View statistics\n" +
                    "6. Exit\n");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            String name = "";

            switch (choice) {
                case 1:
                    name = "social media";
                    break;
                case 2:
                    name = "gaming";
                    break;
                case 3:
                    name = "studying";
                    break;
                case 4:
                    name = "video or streaming";
                    break;
                case 5:
                    System.out.println();
                    System.out.println("===== TODAY'S SCREEN TIME =====");
                    System.out.println("Social media: " + socialMediaTime + " minutes");
                    System.out.println("Gaming: " + gamingTime + " minutes");
                    System.out.println("Studying: " + studyingTime + " minutes");
                    System.out.println("Streaming: " + streamingTime + " minutes");
                    System.out.println();
                    System.out.println("Total screen time: " + totalScreenTime + " minutes");
                    System.out.println("Recorded sessions: " + sessions);
                    System.out.println();

                    int entertainmentTime = socialMediaTime + gamingTime + streamingTime;
                    if (studyingTime > entertainmentTime) {
                        System.out
                                .println("Study screen time is greater than entertainment screen time. Good balance!");
                    } else if (entertainmentTime > studyingTime) {
                        System.out.println("Entertainment screen time is greater than study time.");
                    } else {
                        System.out.println("Study and entertainment screen time are equal.");
                    }

                    if (totalScreenTime < 120) {
                        System.out.println("Low screen time");
                    } else if (totalScreenTime <= 240) {
                        System.out.println("Moderate screen time");
                    } else {
                        System.out.println("High screen time");
                    }
                    break;
                case 6:
                    System.out.println("Screen-time tracker closed.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose a number from 1 to 6.");
                    break;
            }

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter " + name + " minutes: ");
                int minutes = Integer.parseInt(scanner.nextLine());

                if (minutes > 0) {
                    if (choice == 1)
                        socialMediaTime += minutes;
                    else if (choice == 2)
                        gamingTime += minutes;
                    else if (choice == 3)
                        studyingTime += minutes;
                    else
                        streamingTime += minutes;

                    totalScreenTime += minutes;
                    sessions++;
                    System.out.println("Time added successfully!");
                } else {
                    System.out.println("Invalid time. Minutes must be greater than 0.");
                }
            }
        }
    }
}