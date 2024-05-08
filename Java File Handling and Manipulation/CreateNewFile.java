import java.io.File;

public class CreateNewFile {
    public static void main(String[] args) {

        try {

            File file = new File("text1.txt");
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("New file created successfully!");
            } else {
                System.out.println("Error occurred!");
            }
        } catch (Exception e) {
            System.out.println("Error occurred!");
        }

    }
}
