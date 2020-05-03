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

    public JButton btnlogin = new JButton("Log In");
    public JButton btnSignup = new JButton("Sign Up");

    Color bgLogin = new Color(23, 34, 59);
    Color box = new Color(107, 119, 141);
    Color label = new Color(207, 117, 0);
    Color font = new Color(255,255,255);
    Color btn = new Color(33, 230, 193);
    Color btn2 = new Color(73, 156, 84);

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
        title.setBounds(85, 10, 120, 20);
        title.setFont(new Font("Calibri",Font.BOLD,20));
        title.setForeground(font);

        add(luser);
        luser.setBounds(50,50,90, 20);
        luser.setForeground(label);
        add(tfuser);
        tfuser.setBounds(110,50,120,20);
        tfuser.setBackground(box);

        add(lpass);
        lpass.setBounds(50,75,90,20);
        lpass.setForeground(label);
        add(pfpass);
        pfpass.setBounds(110, 75, 120, 20);
        pfpass.setBackground(box);

        add(btnlogin);
        btnlogin.setBounds(100, 100,90,20);
        btnlogin.setBackground(btn);
        btnlogin.setForeground(font);

        add(btnSignup);
        btnSignup.setBounds(100, 125,90,20);
        btnSignup.setBackground(btn2);
        btnSignup.setForeground(font);

    }

    public String getUser() {
        return tfuser.getText();
    }

    public String getPass() {
        return pfpass.getText();
    }
}
