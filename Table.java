import java.util.*;

public class Table {

    static void border(int n, boolean highlight) {
        System.out.print("   +");
        for (int i = 0; i < n; i++) {
            if (highlight)
                System.out.print("------+");
            else
                System.out.print("-----+");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random r = new Random();

        int n;

        while (true) {
            System.out.print("Enter array size (for P×P array): ");

            try {
                n = Integer.parseInt(in.nextLine());

                if (n <= 0) {
                    System.out.println("Array size must be greater than 0.");
                    continue;
                }
                break;

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 2 * (r.nextInt(8) + 1);
            }
        }

        System.out.println("\nGenerated 2D array:\n");

        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%02d   ", i);
        }
        System.out.println();

        border(n, false);

        for (int i = 0; i < n; i++) {

            System.out.printf("%02d |", i);

            for (int j = 0; j < n; j++) {
                System.out.printf(" %2d |", arr[i][j]);
            }

            System.out.println();
            border(n, false);
        }

        int key;

        while (true) {

            System.out.print("\nEnter a number to highlight (even number 2-16): ");

            try {
                key = Integer.parseInt(in.nextLine());

                if (key < 2 || key > 16 || key % 2 != 0) {
                    System.out.println("Please enter an even number between 2 and 16.");
                    continue;
                }
                break;

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }

        int freq = 0;

        System.out.println("\nArray with " + key + " highlighted:\n");

        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%02d    ", i);
        }
        System.out.println();

        border(n, true);

        for (int i = 0; i < n; i++) {

            System.out.printf("%02d |", i);

            for (int j = 0; j < n; j++) {

                if (arr[i][j] == key) {
                    System.out.printf("[%2d]|", arr[i][j]);
                    freq++;
                } else {
                    System.out.printf(" %2d  |", arr[i][j]);
                }
            }

            System.out.println();
            border(n, true);
        }

        System.out.println("\nNumber " + key + " appeared " + freq + " time(s).");

        in.close();
    }
}