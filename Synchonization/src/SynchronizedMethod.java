class TicketBooking {
    private int availableTickets = 5;


    public synchronized void bookTicket(String passengerName, int numberOfTickets) {
        System.out.println(passengerName + " is trying to book " + numberOfTickets + " tickets");


        if (availableTickets >= numberOfTickets) {
            System.out.println("Booking " + numberOfTickets + " tickets for " + passengerName);



            availableTickets -= numberOfTickets;
            System.out.println("Successfully booked " + numberOfTickets + " tickets for " + passengerName);
        } else {
            System.out.println("For " + passengerName + ", not enough tickets available!");
        }

        System.out.println("Remaining tickets: " + availableTickets);
    }
}

public class SynchronizedMethod {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        Thread t1 = new Thread(() -> {
            bookingSystem.bookTicket("Passenger 1", 3);
        });


        Thread t2 = new Thread(() -> {
            bookingSystem.bookTicket("Passenger 2", 4);
        });


        Thread t3 = new Thread(() -> {
            bookingSystem.bookTicket("Passenger 3", 1);
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
