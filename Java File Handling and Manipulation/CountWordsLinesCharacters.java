import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CountWordsLinesCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.next();
        sc.close();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            int lines = 0;
            int words = 0;
            int characters = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                lines++;
                characters += line.length();

                String[] wordStrings = line.split("\\s");
                words += wordStrings.length;
            }

            System.out.println("Number of lines: " + lines);
            System.out.println("Number of words: " + words);
            System.out.println("Number of characters: " + characters);

            reader.close();
        } catch (Exception e) {

        }
    }
}
