import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {

        try {

            File file = new File("text4.txt");

            boolean created = file.createNewFile();

            if (created) {

                System.out.println("New file created successfully!");

                System.out.println();

                FileWriter writer = new FileWriter(file);

                Scanner sc = new Scanner(System.in);

                System.out.println("Enter content to write: ");

                String content = sc.nextLine();

                sc.close();

                writer.write(content);

                writer.close();

                System.out.println("Reading from file: ");
                FileReader reader = new FileReader(file);

                int word;

                while ((word = reader.read()) != -1) {
                    System.out.println((char) word);
                }

                reader.close();
            } else {
                System.out.println("Error occurred!");
            }

        } catch (Exception e) {
            System.out.println("Error occurred!");
        }

    }
}
