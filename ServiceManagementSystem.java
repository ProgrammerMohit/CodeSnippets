import java.util.HashMap;
import java.util.Scanner;

class ServiceManagementSystem {
    // In-memory database for user registration
    private static HashMap<String, String> users = new HashMap<>(); // Stores email-password pairs
    private static HashMap<String, String> userDetails = new HashMap<>(); // Stores user details

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Service Management System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to register a new user
    private static void registerUser(Scanner scanner) {
        System.out.println("\n=== User Registration ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        if (users.containsKey(email)) {
            System.out.println("Email already registered. Try logging in.");
            return;
        }

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        // Save user details
        users.put(email, password);
        userDetails.put(email, "User ID: " + userId + ", Username: " + username + ", Address: " + address + ", Contact: " + contactNumber);

        System.out.println("\n=== Registration Successful ===");
        System.out.println("Welcome, " + username + "!");
    }

    // Method to login a user
    private static void loginUser(Scanner scanner) {
        System.out.println("\n=== User Login ===");

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Validate login credentials
        if (validateLogin(email, password)) {
            System.out.println("\n=== Login Successful ===");
            System.out.println("Welcome, " + email + "!");
            System.out.println("Your Details: " + userDetails.get(email));
            showServiceMenu(scanner);
        } else {
            System.out.println("\n=== Login Failed ===");
            System.out.println("Invalid email or password. Please try again.");
        }
    }

    // Method to validate login credentials
    private static boolean validateLogin(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }

    // Method to display service menu and handle bookings
    private static void showServiceMenu(Scanner scanner) {
        System.out.println("\n=== Available Services ===");
        System.out.println("1. AC Repair");
        System.out.println("2. TV Repair");
        System.out.println("3. Washing Machine Repair");
        System.out.println("4. Fridge Repair");
        System.out.print("Choose a service (1-4): ");
        int serviceChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String serviceName;
        switch (serviceChoice) {
            case 1:
                serviceName = "AC Repair";
                break;
            case 2:
                serviceName = "TV Repair";
                break;
            case 3:
                serviceName = "Washing Machine Repair";
                break;
            case 4:
                serviceName = "Fridge Repair";
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }

        // Book service
        bookService(scanner, serviceName);
    }

    // Method to handle service booking
    private static void bookService(Scanner scanner, String serviceName) {
        System.out.println("\n=== Book Service: " + serviceName + " ===");

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Date of Booking (YYYY-MM-DD): ");
        String bookingDate = scanner.nextLine();

        System.out.print("Enter Vendor Name: ");
        String vendor = scanner.nextLine();

        System.out.print("Enter Service Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Display booking acknowledgment
        System.out.println("\n=== Booking Confirmation ===");
        System.out.println("Service: " + serviceName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Booking Date: " + bookingDate);
        System.out.println("Vendor: " + vendor);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Your service booking is confirmed!");
    }
}
