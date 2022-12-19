package cinema;

import java.util.Objects;
import java.util.Scanner;

public class Cinema {
    public static final int TOTAL_SEATS_SIXTY = 60;
    public static final int TICKET_COST_TEN = 10;
    public static final int TICKET_COST_EIGHT = 8;
    public static int rows;
    public static int seats;
    public static int currentIncome = 0;
    public static int numberOfPurchasedTickets = 0;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Write your code here

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        String[][] array = new String[rows + 1][seats + 1];
        arrangementCreate(array);

        int number = -1;
        while (number != 0) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            number = scanner.nextInt();
            System.out.println();

            int rowTicket = 0;
            int seatTicket;
            double percentage;
            char charPercent = '%';

            switch (number) {
                case 1 -> arrangementShow(array);
                case 2 -> {
                    boolean flag = true;
                    while (flag) {
                        System.out.println("Enter a row number:");
                        rowTicket = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatTicket = scanner.nextInt();

                        if (rowTicket > rows || seatTicket > seats) {
                            System.out.println("Wrong input!");
                        } else if (Objects.equals(array[rowTicket][seatTicket], "B")) {
                            System.out.println("That ticket has already been purchased!");

                        } else {
                            array[rowTicket][seatTicket] = "B";
                            flag = false;
                        }
                    }
                    System.out.print("\nTicket price: ");
                    System.out.println("$" + ticket(rowTicket));
                    currentIncome += ticket(rowTicket);
                    numberOfPurchasedTickets++;
                }
                case 3 -> {
                    percentage = (double) (numberOfPurchasedTickets * 100) / (rows * seats);
                    System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
                    System.out.printf("Percentage: %.2f%c%n", percentage, charPercent);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + sold());
                }
            }
        }
    }

    public static int ticket(int rowTicket) {

        int price;
        int totalSeats = rows * seats;
        int firstRows = rows / 2;

        if (totalSeats <= TOTAL_SEATS_SIXTY) {
            price = TICKET_COST_TEN;
        } else {
            if (rowTicket <= firstRows) {
                price = TICKET_COST_TEN;
            } else {
                price = TICKET_COST_EIGHT;
            }
        }
        return price;
    }

    public static int sold() {
        int totalPrice;
        int totalSeats = rows * seats;
        int firstRows = rows / 2;
        int secondRows = rows - firstRows;
        int frontHalf = firstRows * seats;
        int endHalf = secondRows * seats;

        if (totalSeats <= TOTAL_SEATS_SIXTY) {
            totalPrice = totalSeats * TICKET_COST_TEN;
        } else {
            totalPrice = frontHalf * TICKET_COST_TEN + endHalf * TICKET_COST_EIGHT;
        }
        return totalPrice;
    }

    public static void arrangementCreate(String[][] array) {

        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                array[0][0] = " ";
                array[0][j] = String.valueOf(j);
                array[i][0] = String.valueOf(i);
                array[i][j] = "S";
            }
        }
    }

    public static void arrangementShow(String[][] array) {

        System.out.println("Cinema:");
        for (String[] strings : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }
}