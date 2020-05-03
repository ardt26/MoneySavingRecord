package View;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    JLabel title = new JLabel("Hello, ");

    public JButton btntabungan = new JButton("Record");
    public JButton btngoals = new JButton("Goals");
    public JButton logout = new JButton("Log Out");

    Color bgdashboard = new Color(23, 34, 59);
    Color box1 = new Color(62, 134, 160);
    Color box2 = new Color(152, 118, 170);
    Color font = new Color(255,255,255);
    Color ftitle = new Color(255, 198, 109);

    public DashboardView() {
        getContentPane().setBackground(bgdashboard);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        setVisible(true);
        setLayout(null);
        setSize(300, 200);

        add(title);
        title.setBounds(100, 10, 90, 20);
        title.setFont(new Font("Serif",Font.ITALIC,14));
        title.setForeground(ftitle);

        add(logout);
        logout.setBounds(4,4,85,20);
        logout.setBackground(box2);
        logout.setForeground(font);

        add(btntabungan);
        btntabungan.setBounds(40, 100,90,20);
        btntabungan.setBackground(box1);
        btntabungan.setForeground(font);

        add(btngoals);
        btngoals.setBounds(140,100,90,20);
        btngoals.setBackground(box2);
        btngoals.setForeground(font);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
}
