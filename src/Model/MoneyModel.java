package Model;

import java.sql.Connection;
import  java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MoneyModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/money_record";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public MoneyModel() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void  insertUser(int user_id, String username, String password) {
        try{
            String query = "INSERT INTO `user` (`user_id`, `username`, `password`) VALUES ('"+user_id+"','"+username+"','"+password+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("User Successfully Added");
            JOptionPane.showMessageDialog(null, "Data User Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void  insertTabungan(int tabungan_id, int income, int outcome, int balance, String date, int user_id) {
        try{
            String query = "INSERT INTO `tabungan` (`tabungan_id`, `income`, `outcome`,`balance`,`date`,`user_id`) VALUES ('"+tabungan_id+"','"+income+"','"+outcome+"','"+balance+"','"+date+"','"+user_id+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabungan Successfully Added");
            JOptionPane.showMessageDialog(null, "Data Tabungan Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void  insertGoals(int goals_id, int speciality_income, int goals_balance, String goals_name, int user_id) {
        try{
            String query = "INSERT INTO `goals` (`goals_id`, `speciality_income`, `goals_balance`, `goals_name`, `user_id`) VALUES ('"+goals_id+"','"+speciality_income+"','"+goals_balance+"','"+goals_name+"','"+user_id+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Goals Successfully Added");
            JOptionPane.showMessageDialog(null, "Data Goals Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void  insertGoalsDetail(int detail_id, String goals_date, int amount, int goals_id) {
        try{
            String query = "INSERT INTO `goals_detail` (`detail_id`, `goals_date`, `amount`, `goals_id`) VALUES ('"+detail_id+"','"+goals_date+"','"+amount+"','"+goals_id+"')";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Goals Successfully Added");
            JOptionPane.showMessageDialog(null, "Data Goals Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readUser() {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataUser()][3];

            String query = "Select * from `user`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("user_id");
                data[jmlData][1] = resultSet.getString("username");
                data[jmlData][2] = resultSet.getString("password");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] readTabungan() {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataTabungan()][6];

            String query = "Select * from `mahasiswa`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("tabungan_id");
                data[jmlData][1] = resultSet.getString("income");
                data[jmlData][2] = resultSet.getString("outcome");
                data[jmlData][3] = resultSet.getString("balance");
                data[jmlData][4] = resultSet.getString("date");
                data[jmlData][5] = resultSet.getString("user_id");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] readGoals() {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataGoals()][5];

            String query = "Select * from `goals`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("goals_id");
                data[jmlData][1] = resultSet.getString("speciality_income");
                data[jmlData][2] = resultSet.getString("goals_balance");
                data[jmlData][3] = resultSet.getString("goals_name");
                data[jmlData][4] = resultSet.getString("user_id");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] readGoalsDetail() {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataGoalsDetail()][4];

            String query = "Select * from `goals_detail`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("detail_id");
                data[jmlData][1] = resultSet.getString("goals_date");
                data[jmlData][2] = resultSet.getString("amount");
                data[jmlData][3] = resultSet.getString("goals_id");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public ArrayList<String> readUserID(){
        try{
            ArrayList<String> data = new ArrayList<>();
            String query = "Select * from `user`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data.add(resultSet.getString("user_id"));
            }
            return data;
        }catch (SQLException e) {
            return null;
        }
    }

    public int getBanyakDataUser() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `user`";
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

    public int getBanyakDataTabungan() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `tabungan`";
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

    public int getBanyakDataGoals() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `goals`";
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

    public int getBanyakDataGoalsDetail() {
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `goals_detail`";
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

    public void deleteUser (int user_id) {
        try{
            String query = "DELETE FROM `user` WHERE `user_id` = '"+user_id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void deleteTabungan (int tabungan_id) {
        try{
            String query = "DELETE FROM `tabungan` WHERE `tabungan_id` = '"+tabungan_id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void deleteGoals (int goals_id) {
        try{
            String query = "DELETE FROM `goals` WHERE `goals_id` = '"+goals_id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void deleteGoalsDetail (int detail_id) {
        try{
            String query = "DELETE FROM `goals_detail` WHERE `detail_id` = '"+detail_id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void updateUser(int user_id, String username, String password) {
        try{
            String query = "UPDATE `user` set `user_id`='"+user_id+"', `username`='"+username+"', `password`='"+password+"' where user_id='"+user_id+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("User Successfully Updated");
            JOptionPane.showMessageDialog(null, "Database Updated Successfully");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateTabungan(int tabungan_id, int income, int outcome, int balance, String date, int user_id) {
        try{
            String query = "UPDATE `tabungan` set `tabungan_id`='"+tabungan_id+"', `income`='"+income+"', `outcome`='"+outcome+"', `balance`='"+balance+"', `date`='"+date+"', `user_id`='"+user_id+"' where tabungan_id='"+tabungan_id+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabungan Successfully Updated");
            JOptionPane.showMessageDialog(null, "Database Updated Successfully");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateGoals(int goals_id, int speciality_income, int goals_balance, String goals_name, int user_id) {
        try{
            String query = "UPDATE `goals` set `goals_id`='"+goals_id+"', `speciality_income`='"+speciality_income+"', `goals_balance`='"+goals_balance+"', `goals_name`='"+goals_name+"', `user_id`='"+user_id+"' where goals_id='"+goals_id+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Goals Successfully Updated");
            JOptionPane.showMessageDialog(null, "Database Updated Successfully");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateGoalsDetail(int detail_id, String goals_date, int amount, int goals_id) {
        try{
            String query = "UPDATE `goals_detail` set `detail_id`='"+detail_id+"', `amount`='"+amount+"', `goals_id`='"+goals_id+"' where detail_id='"+detail_id+"'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Goals Detail Successfully Updated");
            JOptionPane.showMessageDialog(null, "Database Updated Successfully");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

}
