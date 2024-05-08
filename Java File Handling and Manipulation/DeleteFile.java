import java.io.File;
import java.util.Scanner;

public class DeleteFile {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter file name to create: ");

            String filename = sc.nextLine();

            File file = new File(filename);

            boolean created = file.createNewFile();

            if (created) {
                System.out.println(filename + " file created successfully!");

                boolean deleted = file.delete();

                if (deleted) {
                    System.err.println(filename + " file deleted successfully!");
                } else {
                    System.err.println("File cannot be deleted!");
                }
            } else {
                System.out.println("File cannot be created!");
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error occurred!");
        }
    }
}
