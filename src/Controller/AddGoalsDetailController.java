package Controller;

import MVC.GoalsDetailMVC;
import MVC.GoalsMVC;
import Model.GoalsModel;
import View.AddGoalsDetailView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGoalsDetailController {
    GoalsModel model;
    AddGoalsDetailView view;
    String data[][];
    String dataDetailGoals[][];
    String dataGoalsTerpilih[];

    public AddGoalsDetailController(GoalsModel model, AddGoalsDetailView view, String[][] data, String dataDetailGoals[][], String dataGoalsTerpilih[]) {
        this.model = model;
        this.view = view;
        this.data = data;
        this.dataDetailGoals = dataDetailGoals;
        this.dataGoalsTerpilih = dataGoalsTerpilih;

        view.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                GoalsMVC goalsMVC = new GoalsMVC(data);
            }
        });

        view.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = view.getAmountGoalsDetail();
                int total;
                if (model.getBanyakDataGoalsDetail(dataGoalsTerpilih[4]) != 0){
                    total = Integer.parseInt(dataDetailGoals[model.getBanyakDataGoalsDetail(dataGoalsTerpilih[4])-1][3].trim()) + Integer.parseInt(amount.trim());
                } else{
                    total = 0 + Integer.parseInt(amount.trim());
                }
                model.insertGoalsDetail(amount, String.valueOf(total), dataGoalsTerpilih[4]);
                if (total >= Integer.parseInt(dataGoalsTerpilih[2])){
                    String status = "Done";
                    model.updateGoalsStatus(status,dataGoalsTerpilih[4]);
                }
                view.setVisible(false);
                GoalsMVC goalsMVC = new GoalsMVC(data);
            }
        });
    }
}
