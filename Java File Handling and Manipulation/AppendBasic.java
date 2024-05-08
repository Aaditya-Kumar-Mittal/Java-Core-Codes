import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class AppendBasic {
    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter file name to append: ");

            String fileName = sc.nextLine();

            File file = new File(fileName);

            if (file.exists()) {

                System.out.println(fileName + " file successfully opened!");

                System.out.println("Enter content to append: ");

                FileWriter writer = new FileWriter(file, true);

                String content = sc.nextLine();

                writer.write("\n" + content);

                writer.close();

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();

            } else {

                System.out.println(fileName + " file does not exist!");
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error Occurred!");
        }
    }
}
