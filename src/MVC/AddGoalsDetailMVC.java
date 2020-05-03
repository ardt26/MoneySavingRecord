package MVC;

import Controller.AddGoalsDetailController;
import Model.GoalsModel;
import View.AddGoalsDetailView;

public class AddGoalsDetailMVC {
    String data[][],dataDetailGoals[][];
    String dataGoalsTerpilih[];

    public AddGoalsDetailMVC(String[][] data, String dataDetailGoals[][], String dataGoalsTerpilih[]) {
        this.data = data;
        this.dataDetailGoals = dataDetailGoals;
        this.dataGoalsTerpilih = dataGoalsTerpilih;
        GoalsModel model = new GoalsModel();
        AddGoalsDetailView view = new AddGoalsDetailView();
        AddGoalsDetailController controller = new AddGoalsDetailController(model,view,data,dataDetailGoals,dataGoalsTerpilih);
    }
}
