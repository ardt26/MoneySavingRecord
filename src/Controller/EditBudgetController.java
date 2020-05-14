package Controller;

import MVC.GoalsDetailMVC;
import MVC.GoalsMVC;
import Model.GoalsModel;
import View.EditBudgetView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditBudgetController {
    GoalsModel model;
    EditBudgetView view;
    String data[][], dataDetailGoals[][];
    String dataGoalsTerpilih[];

    public EditBudgetController(GoalsModel model, EditBudgetView view, String[][] data, String dataGoalsTerpilih[]) {
        this.model = model;
        this.view = view;
        this.data = data;
        this.dataGoalsTerpilih = dataGoalsTerpilih;

        view.setBudget(dataGoalsTerpilih[2]);
        dataDetailGoals = model.readGoalsDetail(dataGoalsTerpilih[4]);

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
                String budget = view.getBudget();
                model.updateGoalsBudget(budget,dataGoalsTerpilih[4]);
                if(Integer.parseInt(dataDetailGoals[model.getBanyakDataGoalsDetail(dataGoalsTerpilih[4])-1][3]) < Integer.parseInt(budget)){
                    String status = "Not Yet";
                    model.updateGoalsStatus(status,dataGoalsTerpilih[4]);
                } else {
                    String status = "Done";
                    model.updateGoalsStatus(status,dataGoalsTerpilih[4]);
                }
                view.setVisible(false);
                GoalsMVC goalsMVC = new GoalsMVC(data);
            }
        });
    }
}
