//kalo list goals di GoalsView diklik muncul detail
package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GoalsDetailView extends JFrame {
    JLabel title;

    JLabel lGoalsID = new JLabel("Goals ID");
    JLabel getlGoalsID = new JLabel("Appearance");
    JLabel lbudget = new JLabel("Budget");
    JLabel getLbudget = new JLabel("Appearance");
    JLabel lbalance = new JLabel("Your Balance");
    JLabel getLbalance = new JLabel("Appearance");

    JButton btnAdd = new JButton("Add");
    JButton back = new JButton();

    JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"No","Date","Amount","Total"};

    Color background = new Color(23, 34, 59);
    Color button1 = new Color(128, 19, 54);
    Color button2 = new Color(62, 134, 160);
    Color ftitle = new Color(255, 198, 109);
    Color tbl  = new Color(237,231,177);
    Color font = new Color(255,255,255);
    Color flabel = new Color(235, 131, 52);

    public GoalsDetailView() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        getContentPane().setBackground(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Money Record");
        setVisible(true);
        setLayout(null);
        setSize(600, 450);


        title = new JLabel("Goals Detail");
        title.setFont(new Font("Cambria",Font.BOLD,24));
        add(title);
        title.setBounds(225, 5, 200, 50);
        title.setForeground(ftitle);

        tabel.setBackground(tbl);
        add(scrollPane);
        scrollPane.setBounds(90,130,420,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        back.setIcon(new ImageIcon("C:\\Users\\Asus\\Documents\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(lGoalsID);
        lGoalsID.setBounds(90,55,90,20);
        lGoalsID.setForeground(font);
        add(getlGoalsID);
        getlGoalsID.setBounds(190, 55, 120,20);
        getlGoalsID.setForeground(flabel);
        getlGoalsID.setBackground(button1);

        add(lbudget);
        lbudget.setBounds(90,80,90,20);
        lbudget.setForeground(font);
        add(getLbudget);
        getLbudget.setBounds(190, 80, 120,20);
        getLbudget.setForeground(flabel);
        getLbudget.setBackground(button1);

        add(lbalance);
        lbalance.setBounds(90,105,90,20);
        lbalance.setForeground(font);
        add(getLbalance);
        getLbalance.setBounds(190, 105, 120,20);
        getLbalance.setForeground(flabel);
        getLbalance.setBackground(button1);

        add(btnAdd);
        btnAdd.setBounds(400, 60, 110, 60);
        btnAdd.setBackground(button2);
        btnAdd.setForeground(font);
    }

}
