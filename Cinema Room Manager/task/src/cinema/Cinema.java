package cinema;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Cinema {
    public static final int TOTAL_SEATS_LIMIT = 60;
    public static final int TICKET_PRICE_STANDARD = 10;
    public static final int TICKET_PRICE_PREMIUM = 8;

    private static int rows;
    private static int seats;
    private static int currentIncome = 0;
    private static int numberOfPurchasedTickets = 0;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Get input: number of rows and seats
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        // Create cinema seating arrangement
        String[][] seatingArrangement = createSeatingArrangement();

        int choice = -1;
        while (choice != 0) {
            // Display menu
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.println();

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showSeatingArrangement(seatingArrangement);
                case 2 -> buyTicket(seatingArrangement);
                case 3 -> displayStatistics();
                case 0 ->
                    // Exit the program
                        System.out.println("Exiting the program. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String[][] createSeatingArrangement() {
        String[][] seatingArrangement = new String[rows][seats];

        // Initialize seating arrangement with available seats
        for (int i = 0; i < rows; i++) {
            Arrays.fill(seatingArrangement[i], "S");
        }

        return seatingArrangement;
    }

    private static void showSeatingArrangement(String[][] seatingArrangement) {
        System.out.println("Cinema:");

        // Display the seating arrangement header
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Display the seating arrangement
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(seatingArrangement[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void buyTicket(String[][] seatingArrangement) {
        int row, seat;

        while (true) {
            // Get input: seat selection
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt();

            // Validate input
            if (row < 1 || row > rows || seat < 1 || seat > seats) {
                System.out.println("Wrong input! Please enter valid seat coordinates.");
                continue;
            }

            // Check if the seat is already purchased
            if (Objects.equals(seatingArrangement[row - 1][seat - 1], "B")) {
                System.out.println("That ticket has already been purchased! Please select another seat.");
            } else {
                // Purchase the ticket
                seatingArrangement[row - 1][seat - 1] = "B";
                int ticketPrice = calculateTicketPrice(row);
                currentIncome += ticketPrice;
                numberOfPurchasedTickets++;

                System.out.println("Ticket price is $" + ticketPrice);
                break;
            }
        }
    }

    private static int calculateTicketPrice(int row) {
        int totalSeats = rows * seats;
        int firstHalfRows = rows / 2;

        if (totalSeats <= TOTAL_SEATS_LIMIT || row <= firstHalfRows) {
            return TICKET_PRICE_STANDARD;
        } else {
            return TICKET_PRICE_PREMIUM;
        }
    }

    private static void displayStatistics() {
        double occupancyPercentage = (double) numberOfPurchasedTickets / (rows * seats) * 100;
        int totalIncome = getTotalIncome();

        System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", occupancyPercentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    private static int getTotalIncome() {
        int totalSeats = rows * seats;
        int firstHalfRows = rows / 2;
        int firstHalfSeats = firstHalfRows * seats;
        int premiumSeats = totalSeats - firstHalfSeats;

        return firstHalfSeats * TICKET_PRICE_STANDARD + premiumSeats * TICKET_PRICE_PREMIUM;
    }
}