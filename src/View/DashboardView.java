package View;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    JLabel title;

    JButton btntabungan = new JButton("Record");
    JButton btngoals = new JButton("Goals");

    Color bgdashboard = new Color(192,252,244);
    Color box1 = new Color(255,89,131);
    Color box2 = new Color(228,193,249);

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

        add(btntabungan);
        btntabungan.setBounds(40, 100,90,20);
        btntabungan.setBackground(box1);

        add(btngoals);
        btngoals.setBounds(140,100,90,20);
        btngoals.setBackground(box2);

    }

}
