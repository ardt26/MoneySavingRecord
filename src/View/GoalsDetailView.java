//kalo list goals di GoalsView diklik muncul detail
package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GoalsDetailView extends JFrame {
    JLabel title;

    JLabel lGoalsID = new JLabel("Goals ID");
    JLabel jGoalsID = new JLabel("Appearance");
    JLabel lbudget = new JLabel("Budget");
    JLabel jBudget = new JLabel("Appearance");
    JLabel lbalance = new JLabel("Your Balance");
    JLabel jBalance = new JLabel("Appearance");

    public JButton btnAdd = new JButton("Add");
    public JButton btnDelete = new JButton("Delete");
    public JButton edit = new JButton();
    public JButton back = new JButton();

    public JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","Date","Amount","Total"};

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

        back.setIcon(new ImageIcon("src\\ImageSource\\back1.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(font);

        add(lGoalsID);
        lGoalsID.setBounds(90,55,90,20);
        lGoalsID.setForeground(font);

        add(jGoalsID);
        jGoalsID.setBounds(190, 55, 120,20);
        jGoalsID.setForeground(flabel);
        jGoalsID.setBackground(button1);

        add(lbudget);
        lbudget.setBounds(90,80,90,20);
        lbudget.setForeground(font);
        add(jBudget);
        jBudget.setBounds(190, 80, 120,20);
        jBudget.setForeground(flabel);
        jBudget.setBackground(button1);

        edit.setIcon(new ImageIcon("src\\ImageSource\\edit.png"));
        add(edit);
        edit.setBounds(265,80,20,20);
        edit.setBackground(font);

        add(lbalance);
        lbalance.setBounds(90,105,90,20);
        lbalance.setForeground(font);
        add(jBalance);
        jBalance.setBounds(190, 105, 120,20);
        jBalance.setForeground(flabel);
        jBalance.setBackground(button1);

        add(btnAdd);
        btnAdd.setBounds(400, 60, 110, 30);
        btnAdd.setBackground(button2);
        btnAdd.setForeground(font);
        add(btnDelete);
        btnDelete.setBounds(400, 90, 110, 30);
        btnDelete.setBackground(button1);
        btnDelete.setForeground(font);
    }

    public void setjGoalsID(String jGoalsID) {
        this.jGoalsID.setText(jGoalsID);
    }

    public void setjBudget(String jBudget) {
        this.jBudget.setText(jBudget);
    }

    public void setjBalance(String jBalance) {
        this.jBalance.setText(jBalance);
    }
}
