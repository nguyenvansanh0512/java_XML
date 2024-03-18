import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Student> studentlist = new ArrayList<>();

        System.out.println("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.println("Sinh vien thu " + i);
            int id = i;
            System.out.print("Ten: ");
            String name = sc.nextLine();
            System.out.print("Tuoi: ");
            int age = sc.nextInt();
            System.out.print("GPA: ");
            float gpa = sc.nextFloat();
            sc.nextLine();;

            Student student = new Student(id, name, age, gpa);
            studentlist.add(student);
        }
        exportToXML(studentlist, 1);

    }

    public static void exportToXML(List<Student> studentlist, int depth) throws IOException {
        try {
            FileWriter writer = new FileWriter("studen.xml");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<students>\n");
            for (Student student : studentlist) {
                String indent = "\t".repeat(depth);
                writer.write(indent + "<id MSV = " + student.getid() + ">\n");
                writer.write(indent + indent + "<name>" + student.getName() + "</name>\n");
                writer.write(indent + indent + "<age>" + student.getAge() + "</age>\n");
                writer.write(indent + indent + "<gpa>" + student.getGpa() + "</gpa>\n");
                writer.write(indent + "</id>\n");
            }
            writer.write("</students>");
            writer.close();

            System.out.println("Da tao file xml thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi khi tao tep XML: " + e.getMessage());
        }
    }

}
class Student {
    private int id;
    private String name;
    private int age;
    private float gpa;

    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getGpa() {
        return gpa;
    }

    public Student(int id, String name, int age, float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
}
