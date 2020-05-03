package Controller;

import MVC.AddGoalsDetailMVC;
import MVC.EditBudgetMVC;
import MVC.GoalsMVC;
import Model.GoalsModel;
import View.GoalsDetailView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoalsDetailController {
    GoalsModel model;
    GoalsDetailView view;
    String data[][], dataDetailGoals[][];
    String dataGoalsTerpilih[];

    public GoalsDetailController(GoalsModel model, GoalsDetailView view, String[][] data, String dataGoalsTerpilih[]) {
        this.model = model;
        this.view = view;
        this.data = data;
        this.dataGoalsTerpilih = dataGoalsTerpilih;

        view.setjGoalsID(dataGoalsTerpilih[4]);
        view.setjBudget(dataGoalsTerpilih[2]);

        if (dataGoalsTerpilih[3].equals("Done")){
            view.btnAdd.setEnabled(false);
        }

        if (model.getBanyakDataGoalsDetail(dataGoalsTerpilih[4]) != 0){
            dataDetailGoals = model.readGoalsDetail(dataGoalsTerpilih[4]);
            view.tabel.setModel(new JTable(dataDetailGoals, view.namaKolom).getModel());
            view.setjBalance(dataDetailGoals[model.getBanyakDataGoalsDetail(dataGoalsTerpilih[4])-1][3]);
        } else{
            view.setjBalance("0");
            JOptionPane.showMessageDialog(null,"Data Tidak Ada");
        }

        view.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                GoalsMVC goalsMVC = new GoalsMVC(data);
            }
        });

        view.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                EditBudgetMVC editBudgetMVC = new EditBudgetMVC(data,dataGoalsTerpilih);
            }
        });

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                AddGoalsDetailMVC addGoalsDetailMVC = new AddGoalsDetailMVC(data,dataDetailGoals,dataGoalsTerpilih);
            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus Goals " + dataGoalsTerpilih[1] + "?","Delete Contact",JOptionPane.YES_NO_OPTION);
                if (input == 0){
                    model.deleteGoals(dataGoalsTerpilih[4]);
                    view.setVisible(false);
                    GoalsMVC goalsMVC = new GoalsMVC(data);
                }
            }
        });
    }
}
