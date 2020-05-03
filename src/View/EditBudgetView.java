package View;

import javax.swing.*;
import java.awt.*;

public class EditBudgetView extends JFrame {
    JLabel title;
    Graphics graphics;

    JLabel leditbudget = new JLabel("New Budget");
    JTextField tfeditbudget = new JTextField();

    public JButton btnAdd = new JButton("Edit");
    public JButton btnCancel = new JButton("Cancel");

    Color bgLogin = new Color(23, 34, 59);
    Color box = new Color(107, 119, 141);
    Color label = new Color(207, 117, 0);
    Color font = new Color(255,255,255);
    Color btn1 = new Color(62, 134, 160);
    Color btn2 = new Color(128, 19, 54);

    public EditBudgetView() {
        getContentPane().setBackground(bgLogin);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        setVisible(true);
        setLayout(null);
        setSize(300, 200);

        title = new JLabel("Edit Budget");
        graphics = title.getGraphics();
        add(title);
        title.setBounds(110, 10, 200, 20);
        title.setFont(new Font("Calibri",Font.BOLD,16));
        title.setForeground(font);

        add(leditbudget);
        leditbudget.setBounds(60,45,90,20);
        leditbudget.setForeground(label);
        add(tfeditbudget);
        tfeditbudget.setBounds(60, 65, 170, 20);
        tfeditbudget.setBackground(box);

        add(btnAdd);
        btnAdd.setBounds(100, 100,90,20);
        btnAdd.setBackground(btn1);
        btnAdd.setForeground(font);

        add(btnCancel);
        btnCancel.setBounds(100, 125,90,20);
        btnCancel.setBackground(btn2);
        btnCancel.setForeground(font);
    }

    public String getBudget() {
        return tfeditbudget.getText();
    }

    public void setBudget(String tfeditbudget) {
        this.tfeditbudget.setText(tfeditbudget);
    }
}
