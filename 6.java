import java.awt.*;
import java.awt.event.*;

public class AWTCalculator extends Frame implements ActionListener {
    TextField tf1, tf2, tfResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    public AWTCalculator() {
        tf1 = new TextField(10);
        tf2 = new TextField(10);
        tfResult = new TextField(10);
        tfResult.setEditable(false);

        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMul = new Button("*");
        btnDiv = new Button("/");

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        setLayout(new FlowLayout());
        add(new Label("Num 1:")); add(tf1);
        add(new Label("Num 2:")); add(tf2);
        add(btnAdd); add(btnSub); add(btnMul); add(btnDiv);
        add(new Label("Result:")); add(tfResult);

        setSize(250, 200);
        setTitle("AWT Calculator");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });
    }

    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(tf1.getText());
        double num2 = Double.parseDouble(tf2.getText());
        double res = 0;

        if (e.getSource() == btnAdd) res = num1 + num2;
        else if (e.getSource() == btnSub) res = num1 - num2;
        else if (e.getSource() == btnMul) res = num1 * num2;
        else if (e.getSource() == btnDiv) res = num1 / num2;

        tfResult.setText(String.valueOf(res));
    }

    public static void main(String[] args) {
        new AWTCalculator();
    }
}
