import java.util.Scanner;

public class Main {

    static final int TOTAL_SEATS = 20;
    static boolean[] seats = new boolean[TOTAL_SEATS];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String username = "admin";
        String password = "1234";

        System.out.println("=================================");
        System.out.println("     BUS RESERVATION SYSTEM");
        System.out.println("=================================");

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (!user.equals(username) || !pass.equals(password)) {
            System.out.println("Invalid Login!");
            return;
        }

        int choice;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. View Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Reservation Status");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewSeats();
                    break;

                case 2:
                    System.out.print("Enter Passenger Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter Seat Number (1-20): ");
                    int seatNo = sc.nextInt();

                    if (seatNo < 1 || seatNo > TOTAL_SEATS) {
                        System.out.println("Invalid Seat Number!");
                    } else if (seats[seatNo - 1]) {
                        System.out.println("Seat Already Booked!");
                    } else {
                        seats[seatNo - 1] = true;
                        System.out.println("Ticket Booked Successfully!");
                        System.out.println("Passenger Name : " + name);
                        System.out.println("Seat Number    : " + seatNo);
                    }
                    break;

                case 3:
                    System.out.print("Enter Seat Number to Cancel: ");
                    int cancelSeat = sc.nextInt();

                    if (cancelSeat < 1 || cancelSeat > TOTAL_SEATS) {
                        System.out.println("Invalid Seat Number!");
                    } else if (!seats[cancelSeat - 1]) {
                        System.out.println("Seat Not Booked!");
                    } else {
                        seats[cancelSeat - 1] = false;
                        System.out.println("Ticket Cancelled Successfully!");
                    }
                    break;

                case 4:
                    reservationStatus();
                    break;

                case 5:
                    System.out.println("Thank You for Using Bus Reservation System");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }

    public static void viewSeats() {
        System.out.println("\n------ Seat Status ------");

        for (int i = 0; i < TOTAL_SEATS; i++) {

            if (seats[i]) {
                System.out.print("[B] ");
            } else {
                System.out.print("[" + (i + 1) + "] ");
            }

            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
    }

    public static void reservationStatus() {

        int booked = 0;

        for (boolean seat : seats) {
            if (seat) {
                booked++;
            }
        }

        System.out.println("\n===== Reservation Report =====");
        System.out.println("Total Seats      : " + TOTAL_SEATS);
        System.out.println("Booked Seats     : " + booked);
        System.out.println("Available Seats  : " + (TOTAL_SEATS - booked));
    }
}
