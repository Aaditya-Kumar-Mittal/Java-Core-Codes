import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingWordsOfAFile {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of the file to open and read: ");
            String filename1 = bufferedReader.readLine();

            System.out.println("Enter the name of the file to write sorted contents: ");
            String filename2 = bufferedReader.readLine();

            File file1 = new File(filename1);

            if (file1.exists()) {

                File file2 = new File(filename2);

                boolean created = file2.createNewFile();
                if (created) {
                    System.out.println("File to write created successfully!");

                    BufferedReader reader = new BufferedReader(new FileReader(file1));

                    List<String> wordStrings = new ArrayList<>();

                    String line;

                    while ((line = reader.readLine()) != null) {

                        String[] wordsArray = line.split("\\s");

                        wordStrings.addAll(Arrays.asList(wordsArray));
                    }

                    Collections.sort(wordStrings);

                    reader.close();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));

                    writer.newLine();

                    for (String string : wordStrings) {
                        writer.write(string + "\n");
                    }

                    writer.close();

                    System.out.println("Printing the contents of the file in sorted order: ");

                    for (String string : wordStrings) {

                        System.out.println(string);

                    }
                } else {

                    System.out.println("File is not created!");
                    return;
                }
            } else {

                System.out.println("File1 not found!");
            }

            bufferedReader.close();

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("File1 not found!");
        }
    }
}
