package View;

import javax.swing.*;
import java.awt.*;

public class WithdrawalSaldoTabunganView extends JFrame {
    JLabel title;
    Graphics graphics;

    JLabel ldesc = new JLabel("Desc");
    JTextField tfdesc = new JTextField();
    JLabel lamount = new JLabel("Amount");
    JTextField tfamount = new JTextField();

    JButton btnAdd = new JButton("Withdraw");
    JButton btnCancel = new JButton("Cancel");
    JButton back = new JButton();

    Color bgLogin = new Color(23, 34, 59);
    Color box = new Color(107, 119, 141);
    Color label = new Color(207, 117, 0);
    Color font = new Color(255,255,255);
    Color btn1 = new Color(62, 134, 160);
    Color btn2 = new Color(128, 19, 54);

    public WithdrawalSaldoTabunganView() {
        getContentPane().setBackground(bgLogin);
        //add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        //pack();
        setVisible(true);
        setLayout(null);
        setSize(300, 200);

        title = new JLabel("Money goes like a rabbit :(");
        graphics = title.getGraphics();
        add(title);
        title.setBounds(55, 10, 200, 20);
        title.setFont(new Font("Calibri",Font.BOLD,16));
        title.setForeground(font);

        back.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(ldesc);
        ldesc.setBounds(50,50,90, 20);
        ldesc.setForeground(label);
        add(tfdesc);
        tfdesc.setBounds(110,50,120,20);
        tfdesc.setBackground(box);

        add(lamount);
        lamount.setBounds(50,75,90,20);
        lamount.setForeground(label);
        add(tfamount);
        tfamount.setBounds(110, 75, 120, 20);
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

    public String getDescWithdraw() {
        return tfdesc.getText();
    }

    public String getAmountWithdraw() {
        return tfamount.getText();
    }

}
