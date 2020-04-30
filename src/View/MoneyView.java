package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class MoneyView extends JFrame {
    JLabel title;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();



    JLabel lNim = new JLabel("NIM        :  ");
    JTextField tfnim = new JTextField();

    JComboBox daftarNim = new JComboBox();

    JButton btnTambahPanel = new JButton("Tambah");
    JButton btnBatalPanel = new JButton("Batal");
    JButton btnUpdatePanel = new JButton("Update");
    JButton btnCancelPanel = new JButton("Cancel");

    JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","Nama","Alamat"};

    public MoneyView() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Money Record");
        pack();
        setVisible(true);

        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
        setLayout(null);
        setSize(600, 500);

        title = new JLabel("Data Mahasiswa");
        add(title);
        title.setBounds(200, 5, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(20,195,480,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
