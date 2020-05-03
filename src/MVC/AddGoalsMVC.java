package MVC;

import Controller.AddGoalsController;
import Model.GoalsModel;
import View.AddGoalsView;

public class AddGoalsMVC {
    String[][] data;

    public AddGoalsMVC(String[][] data) {
        this.data = data;
        GoalsModel model = new GoalsModel();
        AddGoalsView view = new AddGoalsView();
        AddGoalsController controller = new AddGoalsController(model,view,data);
    }
}
