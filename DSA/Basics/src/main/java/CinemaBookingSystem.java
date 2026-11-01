import java.util.Scanner;

public class CinemaBookingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int rows = 5;
        int seatsPerRow = 8;

        char[][] seats = new char[rows][seatsPerRow];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats[i][j] = 'O';
            }
        }

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("   CINEMA BOOKING SYSTEM");
            System.out.println("==============================");
            System.out.println("1. View Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Show Available Seats Count");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            // Option 1: View all seats
            if (choice == 1) {

                System.out.println("\nSeat Layout");
                System.out.println("O = Available");
                System.out.println("X = Booked\n");

                for (int i = 0; i < rows; i++) {

                    System.out.print("Row " + (i + 1) + ": ");

                    for (int j = 0; j < seatsPerRow; j++) {
                        System.out.print(seats[i][j] + " ");
                    }

                    System.out.println();
                }

            }

            // Option 2: Book a seat
            else if (choice == 2) {

                System.out.print("Enter row number (1-" + rows + "): ");
                int row = input.nextInt();

                System.out.print("Enter seat number (1-" + seatsPerRow + "): ");
                int seat = input.nextInt();

                // Check whether the entered row and seat are valid
                if (row < 1 || row > rows || seat < 1 || seat > seatsPerRow) {
                    System.out.println("Invalid row or seat number.");
                }

                // Check whether seat is already booked
                else if (seats[row - 1][seat - 1] == 'X') {
                    System.out.println("This seat is already booked.");
                }

                // Book the seat
                else {
                    seats[row - 1][seat - 1] = 'X';

                    System.out.println(
                            "Seat booked successfully!"
                    );

                    System.out.println(
                            "Row: " + row +
                                    ", Seat: " + seat
                    );
                }
            }

            // Option 3: Count available seats
            else if (choice == 3) {
                int availableSeats = 0;

                for (int i = 0; i < rows; i++) {

                    for (int j = 0; j < seatsPerRow; j++) {

                        if (seats[i][j] == 'O') {
                            availableSeats++;
                        }
                    }
                }

                System.out.println(
                        "Total available seats: "
                                + availableSeats
                );
            }

            // Option 4: Exit
            else if (choice == 4) {
                System.out.println(
                        "Thank you for using the Cinema Booking System."
                );
            }

            // Invalid menu option
            else {
                System.out.println(
                        "Invalid choice. Please choose between 1 and 4."
                );
            }

        } while (choice != 4);

        input.close();
    }
}