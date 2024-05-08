import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class AppendToFile {
    public static void main(String[] args) {

        // Appending content to exisiting file

        try {

            // To read the user input as form of bytes
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String fileString = bufferedReader.readLine();

            File file = new File(fileString);

            if (file.exists()) {

                String content = bufferedReader.readLine();

                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));

                fileWriter.newLine();

                fileWriter.write(content);

                fileWriter.close();

                BufferedReader fileReader = new BufferedReader(new FileReader(file));

                String line;

                while ((line = fileReader.readLine()) != null) {
                    System.out.println(line);
                }

                fileReader.close();

            } else {
                System.out.println("File does not exists!");
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error Occurred!");
        }
    }
}
