import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {
    public static void main(String[] args) {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of the file: ");

            String fileName = bufferedReader.readLine();

            File file = new File(fileName);

            String mostFrequentWord = "";

            int mostFrequentWordCount = 0;

            if (file.exists()) {

                BufferedReader reader = new BufferedReader(new FileReader(file));

                Map<String, Integer> frequencyMap = new HashMap<>();

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] wordsArrray = line.split("\\s");

                    for (String word : wordsArrray) {

                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);

                        if (frequencyMap.get(word) > mostFrequentWordCount) {

                            mostFrequentWord = word;

                            mostFrequentWordCount = frequencyMap.get(word);
                        }
                    }
                }

                reader.close();

                if (mostFrequentWord != "") {
                    System.out.println("Most frequent word is: " + mostFrequentWord);

                    System.out.println("Most frequent word count is: " + mostFrequentWordCount);
                }

                else {
                    System.out.println("No letters found in the file!");
                }

            } else {

                System.out.println("File not found!");

                return;
            }

        } catch (Exception e) {
            System.out.println("File not found!");
        }

    }
}
