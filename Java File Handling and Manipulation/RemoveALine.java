import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveALine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name: ");

        String filename = sc.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("File does not exist.");
        }

        System.out.println("Printing contents of the file: ");

        for (String string : lines) {
            System.out.println(string);
        }

        System.out.println("Enter line number to delete: ");

        int num = sc.nextInt();

        lines.remove(num - 1);

        System.out.println("Printing contents of the file after deletion: ");

        for (String string : lines) {
            System.out.println(string);
        }

        sc.close();
    }
}
