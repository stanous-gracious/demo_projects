# Ticket Reservation System
A simple ticket reservation system books the tickets, temporary holds the ticket, completes the final reservation of seats for multiple users and also performs the cancellation of the booking with the following menu on the console

---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit

The build tool used is Maven.

Note: There are few assumptions to the Demo Application
1) There is no client server architecture to demonstrate the progam functionality
2) There is no MVC architecture to demonstrate the progam functionality
3) Input Validations on user input is not done as there can be lot of variations on data type, data length, data range and limits etc
4) Demo application does book tickets for muliple email-id's as input and store the reservation against multiple email-id which is the key field
5) Application demo is via console/scanner object
6) Menu options drive the user navigation to book the tickets, user can select the menu items {1,2,3,4,5} on console to chose the options
7) Menu options are always available to drive the flow
8) All steps to build and run the program are given below
9) Console Output for All use cases is documented below as part of test completion
10) Junit cases are coded for this Demo

## Prerequisite
Java 8

Maven: To build the package or use intellij maven goals to build the package
mvn package

Running Unit Tests
mvn test


Build/Install the Project or use the library jar provided
Copy the Jar to c:\tech\ticket-reservation-1.0-SNAPSHOT-jar-with-dependencies.jar

## Instructions
Start the Main Class   -- 2 arguments are required to run the program number of rows and number of seats in row for eg : 10 rows and 10 seats in each row

java -cp ticket-reservation-1.0-SNAPSHOT-jar-with-dependencies.jar com.walmart.ticket.reservation.TicketBookingProcessor 10 10

Application will start with the following prompt
2019-07-08 22:18:49 DEBUG TicketBookingProcessor:34 - Welcome to Ticket Booking Application
2019-07-08 22:18:49 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------

1
2019-07-08 22:20:22 DEBUG TicketBookingProcessor:83 - Enter your email id for Ticket Booking:

test.demo@gmail.com
2019-07-08 22:20:31 DEBUG TicketBookingProcessor:85 - Enter the number of seats you want to book

10
2019-07-08 22:20:34 DEBUG TicketBookingProcessor:93 - test.demo@gmail.com, your total seats are 10
2019-07-08 22:20:34 DEBUG TicketServiceImpl:55 - --------------------------------------
2019-07-08 22:20:34 DEBUG TicketServiceImpl:56 - On hold seats before reservation
2019-07-08 22:20:34 DEBUG Reservation:54 - HallRow{rowId=1, availableSeatsInRow=0} [HallSeat{id=1, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=2, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=3, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=4, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=5, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=6, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=7, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=8, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=9, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=10, status=ONHOLD_FOR_RESERVATION}]
2019-07-08 22:20:34 DEBUG Reservation:54 - HallRow{rowId=2, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:34 DEBUG Reservation:54 - HallRow{rowId=3, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:34 DEBUG Reservation:54 - HallRow{rowId=4, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:34 DEBUG Reservation:54 - HallRow{rowId=5, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:34 DEBUG TicketServiceImpl:58 - --------------------------------------
2019-07-08 22:20:34 DEBUG TicketBookingProcessor:98 - Your have temporary hold on below seatsSeatHold{confirmationCode=58, totalSeats=10, requestedSeats={1=1-10}}
2019-07-08 22:20:34 DEBUG TicketBookingProcessor:99 - Temporary hold will expire soon in 20 seconds

2019-07-08 22:20:34 DEBUG TicketBookingProcessor:101 - Confirm 'Y' or 'N' to continue
Y
2019-07-08 22:20:38 INFO  SeatHold:33 - Row number:1
2019-07-08 22:20:38 INFO  SeatHold:34 -  Seat number(s): 1-10
2019-07-08 22:20:38 DEBUG TicketServiceImpl:129 - --------------------------------------
2019-07-08 22:20:38 DEBUG TicketServiceImpl:130 - Seats Available after completing Reservation
2019-07-08 22:20:38 DEBUG Reservation:54 - HallRow{rowId=1, availableSeatsInRow=0} [HallSeat{id=1, status=RESERVATION_CONFIRMED}, HallSeat{id=2, status=RESERVATION_CONFIRMED}, HallSeat{id=3, status=RESERVATION_CONFIRMED}, HallSeat{id=4, status=RESERVATION_CONFIRMED}, HallSeat{id=5, status=RESERVATION_CONFIRMED}, HallSeat{id=6, status=RESERVATION_CONFIRMED}, HallSeat{id=7, status=RESERVATION_CONFIRMED}, HallSeat{id=8, status=RESERVATION_CONFIRMED}, HallSeat{id=9, status=RESERVATION_CONFIRMED}, HallSeat{id=10, status=RESERVATION_CONFIRMED}]
2019-07-08 22:20:38 DEBUG Reservation:54 - HallRow{rowId=2, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:38 DEBUG Reservation:54 - HallRow{rowId=3, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:38 DEBUG Reservation:54 - HallRow{rowId=4, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:38 DEBUG Reservation:54 - HallRow{rowId=5, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:20:38 DEBUG TicketServiceImpl:132 - --------------------------------------
2019-07-08 22:20:38 DEBUG TicketBookingProcessor:109 - Cheers !!!, you tickets are booked with confirmationCode58
2019-07-08 22:20:39 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------

--------------------------------------
2
2019-07-08 22:21:39 DEBUG TicketBookingProcessor:147 - Total Available Open Seats to Book are ===> 40
2019-07-08 22:21:39 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
3
2019-07-08 22:22:20 DEBUG TicketBookingProcessor:127 - Do you want to view your reservation? if so please enter the email id

test.demo@gmail.com
Confirmation Code: 58, Ticket Booking Details: SeatHold{confirmationCode=58, totalSeats=10, requestedSeats={1=1-10}}
2019-07-08 22:22:33 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------

4
2019-07-08 22:23:16 DEBUG TicketBookingProcessor:156 - Do you want to cancel your Reservation
2019-07-08 22:23:16 DEBUG TicketBookingProcessor:157 - Confirm 'Y' or 'N' to continue
Y
2019-07-08 22:23:18 DEBUG TicketBookingProcessor:160 - Enter your email id for Ticket Booking:
test.demo@gmail.com
2019-07-08 22:23:26 DEBUG TicketServiceImpl:112 - --------------------------------------
2019-07-08 22:23:26 DEBUG TicketServiceImpl:113 - Seats Available after removing hold
2019-07-08 22:23:26 DEBUG Reservation:54 - HallRow{rowId=1, availableSeatsInRow=10} [HallSeat{id=1, status=RESERVATION_CONFIRMED}, HallSeat{id=2, status=RESERVATION_CONFIRMED}, HallSeat{id=3, status=RESERVATION_CONFIRMED}, HallSeat{id=4, status=RESERVATION_CONFIRMED}, HallSeat{id=5, status=RESERVATION_CONFIRMED}, HallSeat{id=6, status=RESERVATION_CONFIRMED}, HallSeat{id=7, status=RESERVATION_CONFIRMED}, HallSeat{id=8, status=RESERVATION_CONFIRMED}, HallSeat{id=9, status=RESERVATION_CONFIRMED}, HallSeat{id=10, status=RESERVATION_CONFIRMED}]
2019-07-08 22:23:26 DEBUG Reservation:54 - HallRow{rowId=2, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:23:26 DEBUG Reservation:54 - HallRow{rowId=3, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:23:26 DEBUG Reservation:54 - HallRow{rowId=4, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:23:26 DEBUG Reservation:54 - HallRow{rowId=5, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:23:26 DEBUG TicketServiceImpl:115 - --------------------------------------
2019-07-08 22:23:26 DEBUG TicketBookingProcessor:166 - Your Booking is Cancelled
2019-07-08 22:23:26 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
2
2019-07-08 22:23:59 DEBUG TicketBookingProcessor:147 - Total Available Open Seats to Book are ===> 50
2019-07-08 22:23:59 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
1
2019-07-08 22:24:33 DEBUG TicketBookingProcessor:83 - Enter your email id for Ticket Booking:

test.demo@gmail.com
2019-07-08 22:24:40 DEBUG TicketBookingProcessor:85 - Enter the number of seats you want to book

10
2019-07-08 22:24:42 DEBUG TicketBookingProcessor:93 - test.demo@gmail.com, your total seats are 10
2019-07-08 22:24:42 DEBUG TicketServiceImpl:55 - --------------------------------------
2019-07-08 22:24:42 DEBUG TicketServiceImpl:56 - On hold seats before reservation
2019-07-08 22:24:42 DEBUG Reservation:54 - HallRow{rowId=1, availableSeatsInRow=0} [HallSeat{id=1, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=2, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=3, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=4, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=5, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=6, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=7, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=8, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=9, status=ONHOLD_FOR_RESERVATION}, HallSeat{id=10, status=ONHOLD_FOR_RESERVATION}]
2019-07-08 22:24:42 DEBUG Reservation:54 - HallRow{rowId=2, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:42 DEBUG Reservation:54 - HallRow{rowId=3, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:42 DEBUG Reservation:54 - HallRow{rowId=4, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:42 DEBUG Reservation:54 - HallRow{rowId=5, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:42 DEBUG TicketServiceImpl:58 - --------------------------------------
2019-07-08 22:24:42 DEBUG TicketBookingProcessor:98 - Your have temporary hold on below seatsSeatHold{confirmationCode=96, totalSeats=10, requestedSeats={1=1-10}}
2019-07-08 22:24:42 DEBUG TicketBookingProcessor:99 - Temporary hold will expire soon in 20 seconds

2019-07-08 22:24:42 DEBUG TicketBookingProcessor:101 - Confirm 'Y' or 'N' to continue
2019-07-08 22:24:52 INFO  TicketBookingProcessor:210 - Releasing hold on seats...
2019-07-08 22:24:52 DEBUG TicketServiceImpl:112 - --------------------------------------
2019-07-08 22:24:52 DEBUG TicketServiceImpl:113 - Seats Available after removing hold
2019-07-08 22:24:52 DEBUG Reservation:54 - HallRow{rowId=1, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:52 DEBUG Reservation:54 - HallRow{rowId=2, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:52 DEBUG Reservation:54 - HallRow{rowId=3, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:52 DEBUG Reservation:54 - HallRow{rowId=4, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:52 DEBUG Reservation:54 - HallRow{rowId=5, availableSeatsInRow=10} [HallSeat{id=1, status=OPEN_FOR_RESERVATION}, HallSeat{id=2, status=OPEN_FOR_RESERVATION}, HallSeat{id=3, status=OPEN_FOR_RESERVATION}, HallSeat{id=4, status=OPEN_FOR_RESERVATION}, HallSeat{id=5, status=OPEN_FOR_RESERVATION}, HallSeat{id=6, status=OPEN_FOR_RESERVATION}, HallSeat{id=7, status=OPEN_FOR_RESERVATION}, HallSeat{id=8, status=OPEN_FOR_RESERVATION}, HallSeat{id=9, status=OPEN_FOR_RESERVATION}, HallSeat{id=10, status=OPEN_FOR_RESERVATION}]
2019-07-08 22:24:52 DEBUG TicketServiceImpl:115 - --------------------------------------
2019-07-08 22:24:52 INFO  TicketBookingProcessor:212 - Session Expired!
2019-07-08 22:24:52 INFO  TicketBookingProcessor:213 - total available:50

--------------View Reservation when no seats booked
3
2019-07-08 22:26:36 DEBUG TicketBookingProcessor:127 - Do you want to view your reservation? if so please enter the email id

test.demo@gmail.com
2019-07-08 22:26:44 DEBUG TicketBookingProcessor:136 - Your Don't have any Reservation Details
2019-07-08 22:26:44 DEBUG TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
4
2019-07-08 22:57:58 INFO  TicketBookingProcessor:153 - Do you want to cancel your Reservation
2019-07-08 22:57:58 INFO  TicketBookingProcessor:154 - Confirm 'Y' or 'N' to continue
Y
2019-07-08 22:58:00 INFO  TicketBookingProcessor:157 - Enter your email id for Ticket Booking:
test.demo@gmail.com
2019-07-08 22:58:16 INFO  TicketBookingProcessor:161 - No Reservation Available to Cancel
2019-07-08 22:58:16 INFO  TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
Booking tickets for 3 different users and viewing reservation for all 3 users
--------------------------------------
3
2019-07-08 23:05:14 INFO  TicketBookingProcessor:125 - Do you want to view your reservation? if so please enter the email id

james@gmail.com
2019-07-08 23:05:19 INFO  TicketBookingProcessor:130 - Confirmation Code: 94, Ticket Booking Details: SeatHold{confirmationCode=94, totalSeats=17, requestedSeats={3=1-7, 4=1-10}}
2019-07-08 23:05:19 INFO  TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
3
2019-07-08 23:05:40 INFO  TicketBookingProcessor:125 - Do you want to view your reservation? if so please enter the email id

smith@gmail.com
2019-07-08 23:05:50 INFO  TicketBookingProcessor:130 - Confirmation Code: 35, Ticket Booking Details: SeatHold{confirmationCode=35, totalSeats=10, requestedSeats={2=1-10}}
2019-07-08 23:05:50 INFO  TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
3
2019-07-08 23:05:55 INFO  TicketBookingProcessor:125 - Do you want to view your reservation? if so please enter the email id

test.demo@gmail.com
2019-07-08 23:06:03 INFO  TicketBookingProcessor:130 - Confirmation Code: 29, Ticket Booking Details: SeatHold{confirmationCode=29, totalSeats=20, requestedSeats={1=1-10, 5=1-10}}
2019-07-08 23:06:03 INFO  TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
2
2019-07-08 23:06:09 INFO  TicketBookingProcessor:144 - Total Available Open Seats to Book are ===> 3
2019-07-08 23:06:09 INFO  TicketBookingProcessor:55 -
---------- Enter your choice: ---------
1. Book Seats
2. Show total Available Seats
3. View Reservation
4. Cancel Reservation
5. Exit
--------------------------------------
