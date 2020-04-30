package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;


public class HomeView extends JFrame {
    JLabel title;
    Graphics graphics;

    JPanel panel = new JPanel();

    JLabel luser = new JLabel("User");
    JTextField tfuser = new JTextField();
    JLabel lpass = new JLabel("Password");
    JPasswordField pfpass = new JPasswordField();

    JButton btnlogin = new JButton("Log In");

    Color bgLogin = new Color(192,252,244);
    Color box = new Color(237,231,177);

    public HomeView() {
        getContentPane().setBackground(bgLogin);
        //add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        //pack();
        setVisible(true);
        setLayout(null);
        setSize(300, 200);

        title = new JLabel("WELCOME!");
        graphics = title.getGraphics();
        add(title);
        title.setBounds(110, 10, 90, 20);
        title.setFont(new Font("Calibri",Font.BOLD,16));
        //graphics.setColor(new Color(255,0,0));

        add(luser);
        luser.setBounds(50,50,90, 20);
        add(tfuser);
        tfuser.setBounds(110,50,120,20);
        tfuser.setBackground(box);

        add(lpass);
        lpass.setBounds(50,75,90,20);
        add(pfpass);
        pfpass.setBounds(110, 75, 120, 20);
        pfpass.setBackground(box);

        add(btnlogin);
        btnlogin.setBounds(100, 100,90,20);
        btnlogin.setBackground(box);

    }

    public String getUser() {
        return tfuser.getText();
    }

    public String getPass() {
        return pfpass.getText();
    }
}
