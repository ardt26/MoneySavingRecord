package View;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    JLabel title;

    JButton btntabungan = new JButton("Record");
    JButton btngoals = new JButton("Goals");

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

        title = new JLabel("Hello, ");
        add(title);
        title.setBounds(120, 10, 90, 20);
        title.setFont(new Font("Serif",Font.ITALIC,14));
        title.setForeground(ftitle);

        add(btntabungan);
        btntabungan.setBounds(40, 100,90,20);
        btntabungan.setBackground(box1);
        btntabungan.setForeground(font);

        add(btngoals);
        btngoals.setBounds(140,100,90,20);
        btngoals.setBackground(box2);
        btngoals.setForeground(font);

    }

}
