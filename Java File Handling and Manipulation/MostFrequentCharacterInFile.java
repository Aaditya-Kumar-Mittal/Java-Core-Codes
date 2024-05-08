import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacterInFile {
    public static void main(String[] args) {
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of the file: ");

            String fileName = bufferedReader.readLine();

            File file = new File(fileName);

            char mostFrequentChar = '\0';

            int mostFrequentCharCount = 0;

            if (file.exists()) {

                BufferedReader reader = new BufferedReader(new FileReader(file));

                Map<Character, Integer> frequencyMap = new HashMap<>();

                int currentCharacter;

                while ((currentCharacter = reader.read()) != -1) {

                    char character = (char) currentCharacter;

                    if (Character.isLetter(character)) {

                        frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);

                        if (frequencyMap.get(character) > mostFrequentCharCount) {

                            mostFrequentCharCount = frequencyMap.get(character);

                            mostFrequentChar = character;
                        }
                    }
                }

                reader.close();

                if (mostFrequentChar != '\0') {
                    System.out.println("Most frequent character is: " + mostFrequentChar);

                    System.out.println("Most frequent character count is: " + mostFrequentCharCount);
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
