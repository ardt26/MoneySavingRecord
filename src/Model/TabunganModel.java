package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TabunganModel {

    Statement statement;

    public void  insertTabungan(String user_id) {
        try{
            String query = "INSERT INTO `tabungan` (`user_id`) VALUES ('"+user_id+"')";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabungan Successfully Created");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void  insertTabunganAdd(String description, String income, String total, String tabungan_id) {
        try{
            String date = currentDate();
            String query = "INSERT INTO `tabungan_detail` (`date`,`description`,`income`,`outcome`,`total`,`tabungan_id`) VALUES ('"+date+"','"+description+"','"+income+"','0','"+total+"','"+tabungan_id+"')";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Successfully Added");
            JOptionPane.showMessageDialog(null, "Data Successfully Added");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void  insertTabunganWithdrawal(String description, String outcome, String total, String tabungan_id) {
        try{
            String date = currentDate();
            String query = "INSERT INTO `tabungan_detail` (`date`,`description`,`income`,`outcome`,`total`,`tabungan_id`) VALUES ('"+date+"','"+description+"','0','"+outcome+"','"+total+"','"+tabungan_id+"')";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Successfully Added");
            JOptionPane.showMessageDialog(null, "Data Successfully Added");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readTabungan(String user_id) {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataTabungan(user_id)][9];

            String query = "SELECT * FROM `tabungan` JOIN `tabungan_detail` ON `tabungan`.`tabungan_id` = `tabungan_detail`.`tabungan_id` WHERE `user_id` = '"+user_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            int i = 1;
            while (resultSet.next()){
                data[jmlData][0] = String.valueOf(i);
                data[jmlData][1] = resultSet.getString("date");
                data[jmlData][2] = resultSet.getString("description");
                data[jmlData][3] = resultSet.getString("income");
                data[jmlData][4] = resultSet.getString("outcome");
                data[jmlData][5] = resultSet.getString("total");
                data[jmlData][6] = resultSet.getString("tabungan_id");
                data[jmlData][7] = resultSet.getString("tdetail_id");
                data[jmlData][8] = resultSet.getString("user_id");
                jmlData++;
                i++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakDataTabungan(String user_id) {
        int jmlData = 0;
        try{
            statement = DatabaseConnection.getKoneksi().createStatement();
            String query = "SELECT * FROM `tabungan` JOIN `tabungan_detail` ON `tabungan`.`tabungan_id` = `tabungan_detail`.`tabungan_id` WHERE `user_id` = '"+user_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String currentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
