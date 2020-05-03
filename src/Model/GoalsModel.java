package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GoalsModel {

    Statement statement;

    public void  insertGoals(String budget ,String goals_name, String status, String user_id, String amount) {
        try{
            String query = "INSERT INTO `goals` (`budget`, `goals_name`, `status`, `user_id`) VALUES ('"+budget+"','"+goals_name+"','"+status+"','"+user_id+"')";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            if (!amount.equals("0")){
                String dataGoals[][] = readGoals(user_id);
                insertGoalsDetail(amount,amount,dataGoals[getBanyakDataGoals(user_id)-1][4]);
            } else{
                System.out.println("Goals Successfully Added");
                JOptionPane.showMessageDialog(null, "Data Goals Berhasil");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void  insertGoalsDetail(String amount, String gtotal, String goals_id) {
        try{
            String date = currentDate();
            String query = "INSERT INTO `goals_detail` (`goals_date`, `amount`, `gtotal`, `goals_id`) VALUES ('"+date+"','"+amount+"','"+gtotal+"','"+goals_id+"')";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Goals Successfully Added");
            JOptionPane.showMessageDialog(null, "Data Goals Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readGoals(String user_id) {
        try{
            int jmlData = 0;
            int i = 1;
            String data[][] = new String[getBanyakDataGoals(user_id)][6];

            String query = "Select * from `goals` WHERE `user_id` = '"+user_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = String.valueOf(i);
                data[jmlData][1] = resultSet.getString("goals_name");
                data[jmlData][2] = resultSet.getString("budget");
                data[jmlData][3] = resultSet.getString("status");
                data[jmlData][4] = resultSet.getString("goals_id");
                data[jmlData][5] = resultSet.getString("user_id");
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

    public String[][] readGoalsDetail(String goals_id) {
        try{
            int jmlData = 0;
            int i = 1;
            String data[][] = new String[getBanyakDataGoalsDetail(goals_id)][6];

            String query = "Select * from `goals_detail` WHERE `goals_id` = '"+goals_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = String.valueOf(i);
                data[jmlData][1] = resultSet.getString("goals_date");
                data[jmlData][2] = resultSet.getString("amount");
                data[jmlData][3] = resultSet.getString("gtotal");
                data[jmlData][4] = resultSet.getString("detail_id");
                data[jmlData][5] = resultSet.getString("goals_id");
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

    public int getBanyakDataGoals(String user_id) {
        int jmlData = 0;
        try{
            statement = DatabaseConnection.getKoneksi().createStatement();
            String query = "Select * from `goals` WHERE `user_id` = '"+user_id+"'";
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

    public int getBanyakDataGoalsDetail(String goals_id) {
        int jmlData = 0;
        try{
            statement = DatabaseConnection.getKoneksi().createStatement();
            String query = "Select * from `goals_detail` WHERE `goals_id` = '"+goals_id+"'";
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

    public void deleteGoals (String goals_id) {
        try{
            deleteGoalsDetail(goals_id);
            String query = "DELETE FROM `goals` WHERE `goals_id` = '"+goals_id+"'";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println();
            JOptionPane.showMessageDialog(null, "Goals Successfully Deleted");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void deleteGoalsDetail (String goals_id) {
        try{
            String query = "DELETE FROM `goals_detail` WHERE `goals_id` = '"+goals_id+"'";
            statement = DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void updateGoalsBudget(String budget, String goals_id) {
        try{
            String query = "UPDATE `goals` set `budget`='"+budget+"' WHERE goals_id='"+goals_id+"'";
            statement = (Statement) DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Budget Successfully Updated");
            JOptionPane.showMessageDialog(null, "Budget Successfully Updated");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateGoalsStatus(String status, String goals_id) {
        try{
            String query = "UPDATE `goals` set `status`='"+status+"' WHERE goals_id='"+goals_id+"'";
            statement = (Statement) DatabaseConnection.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Status Successfully Updated");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String currentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
