package View;

import javax.swing.*;
import java.awt.*;

public class SignUpView extends JFrame {
    JLabel title;
    Graphics graphics;

    JPanel panel = new JPanel();

    JLabel lemail = new JLabel("E-mail");
    JTextField tfemail = new JTextField();
    JLabel luser = new JLabel("User");
    JTextField tfuser = new JTextField();
    JLabel lpass = new JLabel("Password");
    JPasswordField pfpass = new JPasswordField();

    public JButton btnSignUp = new JButton("Sign Up");
    public JButton back = new JButton();

    Color bgSignUp = new Color(23, 34, 59);
    Color box = new Color(107, 119, 141);
    Color label = new Color(207, 117, 0);
    Color font = new Color(255,255,255);
    Color btn = new Color(33, 230, 193);

    public SignUpView() {
        getContentPane().setBackground(bgSignUp);
        //add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        //pack();
        setVisible(true);
        setLayout(null);
        setSize(300, 250);

        title = new JLabel("REGISTRATION");
        graphics = title.getGraphics();
        add(title);
        title.setBounds(85, 10, 150, 20);
        title.setFont(new Font("Calibri",Font.BOLD,20));
        title.setForeground(font);

        back.setIcon(new ImageIcon("src\\ImageSource\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(lemail);
        lemail.setBounds(50,50,90, 20);
        lemail.setForeground(label);
        add(tfemail);
        tfemail.setBounds(110,50,120,20);
        tfemail.setBackground(box);

        add(luser);
        luser.setBounds(50,75,90, 20);
        luser.setForeground(label);
        add(tfuser);
        tfuser.setBounds(110,75,120,20);
        tfuser.setBackground(box);

        add(lpass);
        lpass.setBounds(50,100,90,20);
        lpass.setForeground(label);
        add(pfpass);
        pfpass.setBounds(110, 100, 120, 20);
        pfpass.setBackground(box);

        add(btnSignUp);
        btnSignUp.setBounds(100, 125,90,20);
        btnSignUp.setBackground(btn);
        btnSignUp.setForeground(font);

    }

    public String getTfemail() {
        return tfemail.getText();
    }

    public String getTfuser() {
        return tfuser.getText();
    }

    public String getPfpass() {
        return pfpass.getText();
    }
}
