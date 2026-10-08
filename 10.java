import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class StudentManagementSystem {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(int id, String name) {
        studentMap.put(id, new Student(id, name));
    }

    public void updateStudent(int id, String newName) {
        if (studentMap.containsKey(id)) {
            studentMap.get(id).name = newName;
        }
    }

    public Student searchStudent(int id) {
        return studentMap.get(id);
    }

    public void deleteStudent(int id) {
        studentMap.remove(id);
    }

    public void displayAll() {
        for (Student s : studentMap.values()) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent(1, "Alice");
        sms.addStudent(2, "Bob");
        sms.displayAll();
    }
}
