import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Student implements Serializable {

    private String id;
    private String name;
    private int age;
    private int seatingPosition = 0; // Set default value to 0
    private String comments; // Set default value to null

    public Student(String id, String name, int age, int seatingPosition, String comments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.seatingPosition = seatingPosition;
        this.comments = comments;
    }

    // Getters and setters

    public void setSeatingPosition(int position) {
        this.seatingPosition = position;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", seatingPosition=" + seatingPosition +
                ", comments=" + comments +
                '}';
    }
}

public class SerializationOfObject {
    public static void main(String[] args) {

        System.out.println("Enter the name of the file to print serializable object and read it: ");

        Scanner sc = new Scanner(System.in);

        String filename = sc.nextLine();

        sc.close();

        try {
            File file = new File(filename);

            boolean created = file.createNewFile();

            if (created) {

                // Creating Student objects
                Student st1 = new Student("CT1007", "Ganga", 25, 71, "Hard-Working");

                Student st2 = new Student("CT1008", "Yamuna", 26, 51, "Absent-Minded");

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

                System.out.println("Before Serializaation of Objects: ");

                System.out.println("Before serialization st1: " + st1);

                System.out.println("Before serialization st2: " + st2);

                objectOutputStream.writeObject(st1);

                objectOutputStream.writeObject(st2);

                System.out.println("After Serializaation of Objects: ");

                Student restoredStu1 = (Student) objectInputStream.readObject();

                Student restoredStu2 = (Student) objectInputStream.readObject();

                restoredStu1.setSeatingPosition(0);

                restoredStu1.setComments(null);

                restoredStu2.setSeatingPosition(0);

                restoredStu2.setComments(null);

                System.out.println("After deserialization st1: " + restoredStu1);

                System.out.println("After deserialization st2: " + restoredStu2);

                objectInputStream.close();

                objectOutputStream.close();

            } else {
                System.out.println("File cannot be created!");
            }
        } catch (IOException | ClassNotFoundException e) {

            e.printStackTrace();

            System.out.println("File error!");
        }
    }
}
