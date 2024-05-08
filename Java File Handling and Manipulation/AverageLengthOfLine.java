import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageLengthOfLine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name: ");

        String filename = sc.nextLine();

        ArrayList<String> lines = new ArrayList<>();

        int countLines = 0;

        int countChars = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);

                countLines++;

                countChars += line.length();
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("File does not exist.");
        }

        System.out.println("Printing contents of the file: ");

        for (String string : lines) {
            System.out.println(string);
        }

        System.out.println();

        System.out.println("Number of lines in the file: " + countLines);

        System.out.println("Number of characters in the file: " + countChars);

        System.out.println("Average length of a line in the file: " + countChars / countLines);

        System.out.println("Average length of a line in the file: " + (double) countChars / countLines);

        sc.close();
    }
}
