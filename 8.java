import javax.swing.*;
import java.awt.*;

public class StudentRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblName = new JLabel(" Name:");
        JTextField tfName = new JTextField();

        JLabel lblRoll = new JLabel(" Roll Number:");
        JTextField tfRoll = new JTextField();

        JLabel lblCourse = new JLabel(" Course:");
        JTextField tfCourse = new JTextField();

        JButton btnSubmit = new JButton("Submit");

        frame.add(lblName); frame.add(tfName);
        frame.add(lblRoll); frame.add(tfRoll);
        frame.add(lblCourse); frame.add(tfCourse);
        frame.add(new JLabel()); frame.add(btnSubmit);

        frame.setVisible(true);
    }
}
