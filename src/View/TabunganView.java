package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import  java.awt.*;

public class TabunganView extends JFrame {
    JLabel title;

    JLabel lNama = new JLabel("Nama :");
    JTextField tfnama = new JTextField("");
    JLabel lNoHP = new JLabel("No. HP :");
    JTextField tfnohp = new JTextField("");
    JLabel lUmur = new JLabel("Umur :");
    JTextField tfumur = new JTextField("");
    JLabel lEmail = new JLabel("E-mail :");
    JTextField tfemail = new JTextField("");

    JButton btnInsertPanel = new JButton("Insert");
    JButton btnCancel1Panel = new JButton("Cancel");
    JButton back = new JButton();

    JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama","No.HP","Umur","E-mail"};

    Color background = new Color(255, 214, 231);
    Color button1 = new Color(255,89,131);
    Color button2 = new Color(171,245,182);
    Color box = new Color(192,252,244);
    Color box2 = new Color(228,193,249);
    Color tbl  = new Color(237,231,177);

    public TabunganView() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        getContentPane().setBackground(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 450);
        tabel.setBackground(tbl);

        title = new JLabel("CONTACTS");
        add(title);
        title.setBounds(250, 5, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(250,80,320,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        back.setIcon(new ImageIcon(""));

        add(lNama);
        lNama.setBounds(20,65,90,20);
        add(tfnama);
        tfnama.setBounds(110, 65, 120,20);
        tfnama.setBackground(box);
        add(lNoHP);
        lNoHP.setBounds(20, 90, 90, 20);
        add(tfnohp);
        tfnohp.setBounds(110, 90, 120, 20);
        tfnohp.setBackground(box);
        add(lUmur);
        lUmur.setBounds(20, 115, 90, 20);
        add(tfumur);
        tfumur.setBounds(110, 115, 120, 20);
        tfumur.setBackground(box);
        add(lEmail);
        lEmail.setBounds(20, 140, 90, 20);
        add(tfemail);
        tfemail.setBounds(110, 140, 120, 20);
        tfemail.setBackground(box);

        add(btnInsertPanel);
        btnInsertPanel.setBounds(20, 165, 90, 20);
        btnInsertPanel.setBackground(button2);
        add(btnCancel1Panel);
        btnCancel1Panel.setBounds(135, 165, 90, 20);
        btnCancel1Panel.setBackground(button1);
    }
}
