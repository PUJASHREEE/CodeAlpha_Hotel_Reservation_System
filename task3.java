import java.util.Scanner;

class Main {
    private static boolean[] rooms = new boolean[10]; // Array to store room booking status (false = available, true = booked)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View available rooms");
            System.out.println("2. Room details");
            System.out.println("3. Book a room");
            System.out.println("4. Cancel a room");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    
                    System.out.println("Room details:");
                    System.out.println("Single Room:1-5 Cost:Rs.1200");
                    System.out.println("Double Room:5-8 Cost: Rs.1600");
                    System.out.println("Deluxe Room:9-10 Cost:Rs.2000");
                    break;
                case 4:
                    System.out.print("Enter room number to cancel booking (1-10): ");
                    int cancelRoomNumber = scanner.nextInt();
                    cancelBooking(cancelRoomNumber);
                    break;
                case 3:
                System.out.print("Enter room number to book (1-10): ");
                int bookRoomNumber = scanner.nextInt();
                bookRoom(bookRoomNumber);
                break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i]) {
                System.out.println("Room " + (i + 1));
            }
        }
    }

    private static void bookRoom(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= rooms.length) {
            if (!rooms[roomNumber - 1]) {
                rooms[roomNumber - 1] = true;
                System.out.println("Room " + roomNumber + " has been booked.");
                if(roomNumber>=1 && roomNumber<=4)
                System.out.println("Payment for the room is 1200");
                else if(roomNumber>=5 && roomNumber<=8)
                System.out.println("Payment for the room is 1600");
                else
                System.out.println("Payment for the room is 2000");
                    } 
            else {
                System.out.println("Room " + roomNumber + " is already booked.");
            }
        }
         else {
            System.out.println("Invalid room number.");
        }
    }

    private static void cancelBooking(int roomNumber) {
        if (roomNumber > 0 && roomNumber <= rooms.length) {
            if (rooms[roomNumber - 1]) {
                rooms[roomNumber - 1] = false;
                System.out.println("Room " + roomNumber + " booking has been cancelled.");
            } else {
                System.out.println("Room " + roomNumber + " is not booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }
}
