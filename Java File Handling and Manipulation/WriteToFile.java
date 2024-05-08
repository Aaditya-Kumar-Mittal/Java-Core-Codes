import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {

        try {

            File file = new File("text2.txt");
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

            } else {
                System.out.println("Error occurred!");
            }

        } catch (Exception e) {
            System.out.println("Error occurred!");
        }

    }
}
