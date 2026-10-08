import java.io.*;
import java.util.Scanner;

public class StudentFileManagement {
    private static final String FILE_NAME = "student_marks.txt";

    public static void writeMarks(String roll, String name, int marks) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(roll + "," + name + "," + marks);
            System.out.println("Record added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMarks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Student Marks Records ---");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Roll: " + data[0] + " | Name: " + data[1] + " | Marks: " + data[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file or file not found.");
        }
    }

    public static void main(String[] args) {
        writeMarks("101", "Alice", 85);
        writeMarks("102", "Bob", 90);
        readMarks();
    }
}
