package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import  java.awt.*;

public class TabunganView extends JFrame {
    JLabel title;

    JLabel lAmount = new JLabel("Amount :");
    JLabel lAmountDB = new JLabel("Coba Munculin");

    public JButton btnAdd = new JButton("Add");
    public JButton btnWithdraw = new JButton("Withdraw");
    public JButton back = new JButton();

    public JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","Date","Desc","Income","Outcome","Total"};

    Color background = new Color(23, 34, 59);
    Color button1 = new Color(128, 19, 54);
    Color button2 = new Color(62, 134, 160);
    Color ftitle = new Color(255, 198, 109);
    Color tbl  = new Color(237,231,177);
    Color font = new Color(255,255,255);

    public TabunganView() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        getContentPane().setBackground(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        setVisible(true);
        setLayout(null);
        setSize(600, 450);


        title = new JLabel("Money Record");
        title.setFont(new Font("Serif",Font.BOLD,24));
        add(title);
        title.setBounds(225, 5, 200, 50);
        title.setForeground(ftitle);

        tabel.setBackground(tbl);
        add(scrollPane);
        scrollPane.setBounds(90,120,420,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        back.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(lAmount);
        lAmount.setBounds(350,65,90,20);
        lAmount.setForeground(font);
        add(lAmountDB);
        lAmountDB.setBounds(440, 65, 120,20);
        lAmountDB.setForeground(font);

        add(btnAdd);
        btnAdd.setBounds(20, 65, 90, 20);
        btnAdd.setBackground(button2);
        btnAdd.setForeground(font);
        add(btnWithdraw);
        btnWithdraw.setBounds(135, 65, 90, 20);
        btnWithdraw.setBackground(button1);
        btnWithdraw.setForeground(font);
    }

    public void setlAmountDB(String lAmountDB) {
        this.lAmountDB.setText(lAmountDB);
    }
}
