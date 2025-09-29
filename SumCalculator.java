import java.util.*;

public class SumCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers (comma-separated): ");
        String input = sc.nextLine();
        sc.close();

        String[] parts = input.split(",");
        int sum = 0;

        try {
            for (String part : parts) {
                sum += Integer.parseInt(part.trim());
            }
            System.out.println("Sum of numbers = " + sum);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter only numbers separated by commas.");
        }
    }
}
