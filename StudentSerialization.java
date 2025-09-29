import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L; // best practice

    int id;
    String name;
    double gpa;

    Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class StudentSerialization {
    public static void main(String[] args) {
        Student s = new Student(101, "Alice", 9.1);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(s);
            System.out.println("✅ Student serialized successfully!");
        } catch (IOException e) {
            System.out.println("❌ Serialization error: " + e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student obj = (Student) ois.readObject();
            System.out.println("✅ Student deserialized successfully!");
            System.out.println(obj); // uses toString()
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Deserialization error: " + e.getMessage());
        }
    }
}
