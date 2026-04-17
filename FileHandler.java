import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "students.dat";

    public static void saveStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    public static List<Student> loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}