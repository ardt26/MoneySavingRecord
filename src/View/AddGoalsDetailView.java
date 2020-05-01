package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddGoalsDetailView extends JFrame {
    JLabel title;
    Graphics graphics;

    JLabel lamount = new JLabel("Amount");
    JTextField tfamount = new JTextField();

    JButton btnAdd = new JButton("Add");
    JButton btnCancel = new JButton("Cancel");
    JButton back = new JButton();

    Color bgLogin = new Color(23, 34, 59);
    Color box = new Color(107, 119, 141);
    Color label = new Color(207, 117, 0);
    Color font = new Color(255,255,255);
    Color btn1 = new Color(62, 134, 160);
    Color btn2 = new Color(128, 19, 54);

    public AddGoalsDetailView() {
        getContentPane().setBackground(bgLogin);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        setVisible(true);
        setLayout(null);
        setSize(300, 200);

        title = new JLabel("I know you can do it!");
        graphics = title.getGraphics();
        add(title);
        title.setBounds(75, 10, 200, 20);
        title.setFont(new Font("Calibri",Font.BOLD,16));
        title.setForeground(font);

        back.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(lamount);
        lamount.setBounds(60,45,90,20);
        lamount.setForeground(label);
        add(tfamount);
        tfamount.setBounds(60, 65, 170, 20);
        tfamount.setBackground(box);

        add(btnAdd);
        btnAdd.setBounds(100, 100,90,20);
        btnAdd.setBackground(btn1);
        btnAdd.setForeground(font);

        add(btnCancel);
        btnCancel.setBounds(100, 125,90,20);
        btnCancel.setBackground(btn2);
        btnCancel.setForeground(font);
    }

    public String getAmountGoalsDetail() {
        return tfamount.getText();
    }

}
