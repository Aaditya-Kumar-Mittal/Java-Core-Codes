import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfWord {

    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String filename = bufferedReader.readLine();

            File file = new File(filename);

            if (file.exists()) {

                BufferedReader reader = new BufferedReader(new FileReader(file));

                Map<String, Integer> frequency = new HashMap<>();

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] wordStrings = line.split("\\s");

                    for (String string : wordStrings) {

                        string = string.replaceAll("[^a-zA-Z]", "").toLowerCase();

                        if (!string.isEmpty()) {

                            frequency.put(string, frequency.getOrDefault(string, 0) + 1);
                        }
                    }
                }

                reader.close();

                System.out.println("Printing the frequency of each word: ");

                for (Map.Entry<String, Integer> entry : frequency.entrySet()) {

                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }

            } else {
                System.out.println("File does not exist!");
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("File does not exist!");
        }
    }
}
