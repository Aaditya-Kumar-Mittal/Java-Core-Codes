import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class DesiredCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String filename = sc.nextLine();

        sc.close();

        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int countCharacters = 0;

            String line;

            while ((line = reader.readLine()) != null) {
                countCharacters += line.length();
            }

            System.out.println("Number of characters: " + countCharacters);

            reader.close();

            if (countCharacters < 250) {
                System.out.println("Count of characters less than 250.");
            } else if (countCharacters == 250) {
                System.out.println("Count of characters equal to 250.");
            } else {
                System.out.println("Count of characters more than 250.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred!");
        }

    }
}
