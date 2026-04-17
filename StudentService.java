import java.util.*;

public class StudentService {
    private List<Student> students;

    public StudentService() {
        students = FileHandler.loadStudents();
    }

    public void addStudent(Student s) {
        students.add(s);
        FileHandler.saveStudents(students);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found");
            return;
        }
        students.forEach(System.out::println);
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student s = findStudent(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            FileHandler.saveStudents(students);
            System.out.println("Updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        FileHandler.saveStudents(students);
        System.out.println("Deleted successfully");
    }
}