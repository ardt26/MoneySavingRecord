package View;

import javax.swing.*;
import java.awt.*;

public class AddGoalsView extends JFrame {
    JLabel title;
    Graphics graphics;

    JLabel lname = new JLabel("Goals Name");
    JTextField tfname = new JTextField();
    JLabel lbudget = new JLabel("Budget");
    JTextField tfbudget = new JTextField();
    JLabel lbalance = new JLabel("First Balance");
    JTextField tfbalance = new JTextField();

    JButton btnAdd = new JButton("Add");
    JButton btnCancel = new JButton("Cancel");
    JButton back = new JButton();

    Color bgLogin = new Color(23, 34, 59);
    Color box = new Color(107, 119, 141);
    Color label = new Color(207, 117, 0);
    Color font = new Color(255,255,255);
    Color btn1 = new Color(62, 134, 160);
    Color btn2 = new Color(128, 19, 54);

    public AddGoalsView() {
        getContentPane().setBackground(bgLogin);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        setVisible(true);
        setLayout(null);
        setSize(300, 250);

        title = new JLabel("Add Your New Goal");
        graphics = title.getGraphics();
        add(title);
        title.setBounds(80, 20, 200, 20);
        title.setFont(new Font("Calibri",Font.BOLD,16));
        title.setForeground(font);

        back.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(lname);
        lname.setBounds(35,50,90,20);
        lname.setForeground(label);
        add(tfname);
        tfname.setBounds(125, 50, 120, 20);
        tfname.setBackground(box);

        add(lbudget);
        lbudget.setBounds(35,75,90,20);
        lbudget.setForeground(label);
        add(tfbudget);
        tfbudget.setBounds(125, 75, 120, 20);
        tfbudget.setBackground(box);

        add(lbalance);
        lbalance.setBounds(35,100,90,20);
        lbalance.setForeground(label);
        add(tfbalance);
        tfbalance.setBounds(125, 100, 120, 20);
        tfbalance.setBackground(box);

        add(btnAdd);
        btnAdd.setBounds(40, 150,90,20);
        btnAdd.setBackground(btn1);
        btnAdd.setForeground(font);

        add(btnCancel);
        btnCancel.setBounds(150, 150,90,20);
        btnCancel.setBackground(btn2);
        btnCancel.setForeground(font);
    }

    public String getGoalsName() {
        return tfname.getText();
    }

    public String getGoalsBudget() {
        return tfbudget.getText();
    }

    public String getGoalsBalance() {
        return tfbalance.getText();
    }
}
