package Controller;

import MVC.GoalsMVC;
import Model.GoalsModel;
import View.AddGoalsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGoalsController {
    GoalsModel model;
    AddGoalsView view;
    String data[][];

    public AddGoalsController(GoalsModel model, AddGoalsView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;

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
                String name = view.getGoalsName();
                String budget = view.getGoalsBudget();
                String firtsBalance = view.getGoalsBalance();
                String status;
                if (Integer.parseInt(firtsBalance.trim()) >= Integer.parseInt(budget.trim())){
                    status = "Done";
                } else {
                    status = "Not Yet";
                }
                model.insertGoals(budget,name,status,data[0][0],firtsBalance);
                view.setVisible(false);
                GoalsMVC goalsMVC = new GoalsMVC(data);
            }
        });
    }
}
