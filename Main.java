import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    service.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student s = service.findStudent(sc.nextInt());
                    System.out.println(s != null ? s : "Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int uage = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String ucourse = sc.nextLine();

                    service.updateStudent(uid, uname, uage, ucourse);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    service.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}