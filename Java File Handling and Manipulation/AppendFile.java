import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class AppendFile {
    public static void main(String[] args) {

        try {

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the File Name to append: ");
            String fileName = inputReader.readLine();

            File file = new File(fileName);

            if (file.exists()) {
                System.out.println("Enter content to append to the file");

                String content = inputReader.readLine();

                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));

                fileWriter.newLine();

                fileWriter.write(content);

                fileWriter.close();

                BufferedReader fileReader = new BufferedReader(new FileReader(file));

                String line;
                System.out.println();
                System.out.println("Reading the file after appending!");
                System.out.println();

                while ((line = fileReader.readLine()) != null) {
                    System.out.println(line);
                }

                fileReader.close();

            } else {
                System.out.println("File does not exists!");
            }

            inputReader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error Occurred!");
        }
    }
}
