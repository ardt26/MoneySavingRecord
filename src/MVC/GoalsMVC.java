package MVC;

import Controller.GoalsController;
import Model.GoalsModel;
import View.GoalsView;

public class GoalsMVC {
    String data[][];

    public GoalsMVC(String[][] data) {
        this.data = data;
        GoalsModel model = new GoalsModel();
        GoalsView view = new GoalsView();
        GoalsController controller = new GoalsController(model,view,data);
    }
}
