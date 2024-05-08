import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamToBytesArray {
    public static void main(String[] args) {
        try {

            System.out.println("Enter the name of the file: ");

            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

            String filename = reader.readLine();

            File file = new File(filename);

            if (file.exists()) {

                FileInputStream fileInputStream = new FileInputStream(file);

                ByteArrayOutputStream byteArray=new ByteArrayOutputStream();

                byte[] buffer=new byte[1024];

                int bytesRead;

                while ((bytesRead=fileInputStream.read(buffer))!=-1) {
                    
                    byteArray.write(buffer,0,bytesRead);
                }

                byte[] bA=byteArray.toByteArray();

                System.out.println("Byte Array Length: "+bA.length);

                fileInputStream.close();
            }

        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }
}
