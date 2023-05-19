# Cinema Ticket Reservation System

The Cinema Ticket Reservation System is a simple command-line program that allows users to reserve movie tickets in a fictional cinema. It provides basic functionalities such as displaying the seating arrangement, purchasing tickets, and viewing ticket sales statistics. The program is implemented in Java and can be run from the command line.

## Features

- **Seating Arrangement**: Users can view the seating arrangement of the cinema, which shows the available seats and purchased seats.
- **Ticket Purchase**: Users can select a seat to purchase a ticket. The program ensures that the seat is available and not already purchased.
- **Ticket Price**: After purchasing a ticket, the program displays the ticket price based on a pricing algorithm that considers the number of seats in the cinema and the selected row.
- **Statistics**: Users can view ticket sales statistics, including the number of purchased tickets, the percentage of sold tickets compared to the total number of seats, current income, and total potential income.
- **User-Friendly Interface**: The program provides a clear and intuitive command-line interface for easy interaction.

## Getting Started

1. Ensure you have Java installed on your machine.
2. Clone this repository to your local machine.
3. Open a terminal or command prompt and navigate to the project directory.
4. Compile the Java source file using the following command:
```
javac Cinema.java
```

5. Run the program with the following command:
```
java Cinema
```

## Usage

Upon running the program, follow the on-screen instructions to interact with the system. The program will prompt you to enter the number of rows and seats in the cinema. Once the cinema is set up, a menu will be displayed with the available options. Use the corresponding numbers to select the desired operation:

1. Show the seats: Displays the current seating arrangement.
2. Buy a ticket: Allows you to purchase a ticket by selecting a seat.
3. Statistics: Shows ticket sales statistics.
0. Exit: Terminates the program.

## Example
```
Enter the number of rows:
5
Enter the number of seats in each row:
6

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 1

Cinema:
1 2 3 4 5 6
1 S S S S S S
2 S S S S S S
3 S S S S S S
4 S S S S S S
5 S S S S S S

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 2

Enter a row number:
3
Enter a seat number in that row:
4

Ticket purchased successfully! The price is $10

Show the seats
Buy a ticket
Statistics
Exit
3

Number of purchased tickets: 1
Percentage: 3.33%
Current income: $10
Total income: $300

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
> 0

Exiting the program. Goodbye!
```

## Contributing
If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License
This project is licensed under The MIT License. Feel free to use, modify, and distribute the code as needed.
