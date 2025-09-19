import java.util.Scanner;

/**
 * The program asks the user for a log length and tells them
 * how many such logs can fit in a truck of fixed mass capacity.
 *
 * @author Angel
 * @version 1.0
 * @since 2025-09-16
 */

public final class Logging {

    /** Constant for mass of truck (kg). */
    public static final float TRUCK_MASS = 1100.0f;

    /** Constant for max log mass (kg). */
    public static final float MAX_LOG_MASS = 20.0f;

    /** Constant for quarter meter length. */
    public static final float QUARTER_LENGTH = 0.25f;

    /** Constant for half meter length. */
    public static final float HALF_LENGTH = 0.5f;

    /** Constant for full meter length. */
    public static final float FULL_LENGTH = 1.0f;

    /**
     * Private constructor to prevent instantiation.
     */
    private Logging() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method that runs the program.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {

        System.out.println("Welcome to the Logging Company.");
        System.out.println("Enter one of the following log");
        System.out.println(" lengths (in meters): 0.25, 0.5, 1.0");

        // Using Scanner for input
        Scanner scanner = new Scanner(System.in);
        final String logLengthString = scanner.nextLine();

        try {
            // Convert input to float
            final float logLength = Float.parseFloat(logLengthString);

            // Check for negative or zero input
            if (logLength <= 0) {
                System.out.println("The log length must be a positive number.");

            // Check if log length is valid
        } else if (logLength != QUARTER_LENGTH
            && logLength != HALF_LENGTH
                && logLength != FULL_LENGTH) {
                System.out.println("Invalid log length.");
                System.out.println(" Please enter 0.25, 0.5, or 1.0 meters.");
            } else {
                // Calculate number of logs
                final float numberOfLogs = TRUCK_MASS
                / (MAX_LOG_MASS * logLength);
                // Output result
                System.out.printf("The number of %.2fm logs that can fit in the truck is: %.0f%n",
        logLength, numberOfLogs);
            }

        } catch (NumberFormatException error) {
            System.out.println("Invalid input.");
            System.out.println(" Please enter a numeric value");
            System.out.println(" (e.g., 0.25, 0.5, or 1.0).");
        }

        // Close scanner
        scanner.close();
    }
}
