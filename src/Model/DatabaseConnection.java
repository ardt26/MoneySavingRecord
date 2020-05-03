package Model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/money_record";
    static final String USER = "root";
    static final String PASS = "";

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null){
            try{
                Class.forName(JDBC_DRIVER);
                koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Koneksi Berhasil");
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Koneksi Gagal");
            }
        }
        return koneksi;
    }

}
