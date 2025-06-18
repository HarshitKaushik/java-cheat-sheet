import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerInput {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Reading a line (useful for reading entire sentences)
      System.out.println("Enter a full line of text:");
      String fullLine = scanner.nextLine();
      System.out.println("You entered: " + fullLine);

      // Reading individual words (tokens)
      System.out.println("\nEnter three words:");
      String word1 = scanner.next();
      String word2 = scanner.next();
      String word3 = scanner.next();
      System.out.println("Words entered: " + word1 + ", " + word2 + ", " + word3);

      scanner.nextLine(); // Clear buffer after next()

      // Reading an integer with validation
      System.out.println("\nEnter an integer:");
      if (scanner.hasNextInt()) {
        int number = scanner.nextInt();
        System.out.println("You entered integer: " + number);
      } else {
        System.out.println("Invalid input, not an integer.");
        scanner.next(); // Consume invalid token
      }

      // Reading multiple types in one line
      System.out.println("\nEnter your name and age:");
      String name = scanner.next();
      int age = scanner.nextInt();
      System.out.println("Name: " + name + ", Age: " + age);

      scanner.nextLine(); // Clear buffer

      // Trick: Using delimiter to read comma-separated values
      System.out.println("\nEnter comma-separated numbers (e.g., 1,2,3):");
      scanner.useDelimiter(",");
      try {
        while (scanner.hasNextInt()) {
          int value = scanner.nextInt();
          System.out.println("Read number: " + value);
        }
      } catch (InputMismatchException e) {
        System.out.println("Non-integer input encountered.");
      }

    } catch (InputMismatchException e) {
      System.out.println("Input type mismatch: " + e.getMessage());
    } catch (NoSuchElementException e) {
      System.out.println("No input was provided: " + e.getMessage());
    } catch (IllegalStateException e) {
      System.out.println("Scanner is closed: " + e.getMessage());
    } finally {
      scanner.close();
      System.out.println("\nScanner closed.");
    }
  }
}
