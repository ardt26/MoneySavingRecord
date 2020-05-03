package Controller;

import MVC.AddGoalsMVC;
import MVC.DashboardMVC;
import MVC.GoalsDetailMVC;
import Model.GoalsModel;
import View.GoalsView;

import javax.swing.*;
import java.awt.event.*;

public class GoalsController {

    GoalsModel model;
    GoalsView view;
    String data[][], dataGoals[][];

    public GoalsController(GoalsModel model, GoalsView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;

        if (model.getBanyakDataGoals(data[0][0]) != 0){
            dataGoals = model.readGoals(data[0][0]);
            view.tabel.setModel(new JTable(dataGoals, view.namaKolom).getModel());
        } else{
            JOptionPane.showMessageDialog(null,"Data Tidak Ada");
        }

        view.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                DashboardMVC dashboardMVC = new DashboardMVC(data);
            }
        });

        view.btnAddGoals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                AddGoalsMVC addGoalsMVC = new AddGoalsMVC(data);
            }
        });

        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                view.setVisible(false);
                int baris = view.tabel.getSelectedRow();
                String dataGoalsTerpilih[] = new String[6];
                for(int i = 0; i < 6; i++){
                    dataGoalsTerpilih[i] = dataGoals[baris][i];
                }
                GoalsDetailMVC goalsDetailMVC = new GoalsDetailMVC(data,dataGoalsTerpilih);
            }
        });
    }
}
